package com.uver.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.google.gson.Gson;
import com.uver.cmn.ImgView;
import com.uver.cmn.Message;
import com.uver.cmn.StringUtil;
import com.uver.service.EventImgService;
import com.uver.vo.EventImgVO;
import com.uver.vo.ImgVO;

@Controller("EventImgController")
@RequestMapping("img/")
public class EventImgController {
	private static final Logger LOG = LoggerFactory.getLogger(EventImgController.class);
	
	private final EventImgService eventImgService;
//	private final View downloadView;
	
	/**
	 * 파일 시스템에 있는 이미지 파일 응답으로 돌려주기
	 */
	private final View imgView;
	
	public EventImgController(EventImgService eventImgService, View imgView) {
		this.eventImgService = eventImgService;
		this.imgView = imgView;
	}
	
	private final String UPLOAD_FILE_DIR = ImgVO.DIR;
	
	
	/**
	 * 이미지 객체 받아서 화면에 이미지 뿌리기
	 * @param imgSeq
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("{imgSeq}.do")
	private ImgView getImg(@PathVariable int imgSeq, ModelMap modelMap) {
		
		EventImgVO eventImg = eventImgService.doSelectOne(imgSeq);
		ImgVO img = eventImg.getImgVO();
		modelMap.put("img", img);
		
		return (ImgView) imgView;
	}
	
	

	/**
	 * 이미지 업로드 -> 이미지 목록 페이지로 맵핑
	 * 
	 * @param ModelAndView
	 * @return ModelAndView
	 */
	@RequestMapping(value="doSelectList.do", method=RequestMethod.GET)
	public ModelAndView doSelectList(ModelAndView mav) {
		List<EventImgVO> list = new ArrayList<>();

		//event seq
		list = eventImgService.doSelectAll(2);
		
		int cnt = eventImgService.count(2);
		
		mav.addObject("list", list);
		mav.addObject("cnt", cnt);
		mav.setViewName("img_view");
		
		return mav;
	}
	
	
	
	/**
	 * 이미지 업로드 후 json으로 응답
	 * 
	 * @param mReg
	 * @return json
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value="doInsert.do", method=RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(MultipartHttpServletRequest mReg) throws IllegalStateException, IOException {
		
		LOG.debug("-----------------------");
		LOG.debug("doInsert()");
		LOG.debug("-----------------------");
		
		//--- 이미지 저장 경로 설정
		File fileRootDir = new File(UPLOAD_FILE_DIR);
		if(fileRootDir.isDirectory()==false) {
			boolean flag = fileRootDir.mkdir();
			LOG.debug("[fileRootDir 생성] " + flag);
		}
		
		List<EventImgVO> list = new ArrayList<>();
		List<MultipartFile> imgList = mReg.getFiles("images[]");
		int flag = 0;
		
		for (MultipartFile mf : imgList) {
			
			//원래 이름
			String orgImgNm = mf.getOriginalFilename();
			if(orgImgNm.equals("") || orgImgNm == null) {
				continue;
			}
			LOG.debug("[orgFileNm] " + orgImgNm);
			
			//서버에 저장될 이름
			String saveImgNm = StringUtil.getPK("yyyyMMddHHmmss");
			LOG.debug("[saveFileNm]" + saveImgNm);
			
			//확장자
			String ext = "";
			if(orgImgNm.indexOf(".") > -1) {
				ext = orgImgNm.substring(orgImgNm.lastIndexOf(".")+1);
				LOG.debug("[확장자] " + ext);
				//saveImgNm += "." + ext;
			}
			
			//사이즈 long -> int
			int size = (int) mf.getSize();
			LOG.debug("[파일크기] " + size);
			
			
			ImgVO imgVO = new ImgVO(
					126,
					orgImgNm,
					saveImgNm,
					ext,
					size,
					"n",
					"regDt",
					"regId01"
					);
			LOG.debug("[imgVO] " + imgVO);
			
			//param - imgSeq, eventSeq, imgVO
			EventImgVO eventImgVO = new EventImgVO(126, 2, imgVO);
			LOG.debug("[eventImgVO] " + eventImgVO);
			
			flag += eventImgService.doInsert(eventImgVO);
			
			
			//저장 파일 full path
			File fullPathFile = new File(fileRootDir, saveImgNm + "." + ext);
			LOG.debug("[fullPathFile] " + fullPathFile);
			LOG.debug("[full Path] " + fullPathFile.getAbsoluteFile());
			
			list.add(eventImgVO);
			mf.transferTo(new File(fullPathFile.getAbsolutePath()));
			LOG.debug("[full path]" + fullPathFile.getAbsolutePath());
		}
		
		
		Message message=new Message();
        message.setMsgId(String.valueOf(flag));
        
        if(flag > 0) {
        	message.setMsgContents("이미지가 등록되었습니다.");
        }else {
        	message.setMsgContents("이미지 등록을 실패했습니다.");
        }
		
		Gson gson = new Gson();
		String json = gson.toJson(message);
        LOG.debug("[json] "+json);
		return json;
	}
	
	
	/**
	 * view.do -> 이미지 업로드 페이지 맵핑
	 * 
	 * @return img_upload.jsp
	 */
	@RequestMapping(value="view.do")
	public String view() {
		LOG.debug("-------------------");
		LOG.debug("view()");
		LOG.debug("-------------------");
		
		return "img_upload";
	}

}
