package com.uver.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.uver.cmn.StringUtil;
import com.uver.service.EventImgService;
import com.uver.vo.EventImgVO;
import com.uver.vo.ImgVO;

@Controller("EventImgController")
@RequestMapping("img/")
public class EventImgController {
	private static final Logger LOG = LoggerFactory.getLogger(EventImgController.class);
	
	private final EventImgService eventImgService;
	
	public EventImgController(EventImgService eventImgService) {
		this.eventImgService = eventImgService;
	}
	
	
	
	// 외부 경로 설정 필요
	final String UPLOAD_FILE_DIR = "D:\\upload_img";
	
	
	/**
	 * 이미지 다운로드
	 * 
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value="download.do", method = RequestMethod.POST)
	public ModelAndView download(HttpServletRequest req, ModelAndView modelAndView) {
		
		LOG.debug("download()");
		
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="doInsert.do", method=RequestMethod.POST)
	public ModelAndView doInsert(MultipartHttpServletRequest mReg, ModelAndView modelAndView) throws IllegalStateException, IOException {
		
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
			
			eventImgService.doInsert(eventImgVO);
			
			
			//저장 파일 full path
			File fullPathFile = new File(fileRootDir, saveImgNm + "." + ext);
			LOG.debug("[fullPathFile] " + fullPathFile);
			
			list.add(eventImgVO);
			mf.transferTo(new File(fullPathFile.getAbsolutePath()));
			LOG.debug("[full path]" + fullPathFile.getAbsolutePath());
		}
		
		
		modelAndView.addObject("list",list);
		modelAndView.setViewName("img_upload"); //WEB-INF/views/img.jsp
		
		return modelAndView;
	}
	
	
	
	//--- 통신 테스트
	@RequestMapping(value="view.do")
	public String view() {
		LOG.debug("-------------------");
		LOG.debug("view()");
		LOG.debug("-------------------");
		
		return "img_upload";
	}

}
