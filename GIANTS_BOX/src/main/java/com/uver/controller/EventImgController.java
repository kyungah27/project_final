package com.uver.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.google.gson.Gson;
import com.uver.cmn.ImgView;
import com.uver.cmn.Message;
import com.uver.cmn.Search;
import com.uver.cmn.StringUtil;
import com.uver.service.EventImgService;
import com.uver.vo.EventImgVO;
import com.uver.vo.ImgVO;
import com.uver.vo.MemberVO;

import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@Controller("EventImgController")
@RequestMapping("img/")
public class EventImgController {
	private static final Logger LOG = LoggerFactory.getLogger(EventImgController.class);

	private final EventImgService eventImgService;

	/**
	 * 파일 시스템에 있는 이미지 파일 응답으로 돌려주기
	 */
	private final View imgView;

	@Value("${file.path}")
	private String UPLOAD_FILE_DIR;

	public EventImgController(EventImgService eventImgService, View imgView) {
		this.eventImgService = eventImgService;
		this.imgView = imgView;
	}

	/**
	 * 이미지 객체 받아서 화면에 이미지 뿌리기
	 * 
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
	@RequestMapping(value = "doSelectList.do", method = RequestMethod.GET)
	public ModelAndView doSelectList(@RequestParam int eventSeq, ModelAndView mav) {
		Search search = new Search(eventSeq, 1, 5);

		int maxImgSeq = eventImgService.getMaxImgSeq(eventSeq);
		search.setSearchSeqSub(maxImgSeq);

		// event seq
		List<EventImgVO> list = eventImgService.doSelectList(search);

		int cnt = list.get(0).getTotalCnt();

		mav.addObject("list", list);
		mav.addObject("cnt", cnt);
		mav.addObject("maxImgSeq", maxImgSeq);
		mav.addObject("eventSeq", search.getSearchSeq());

		mav.setViewName("img_view");

		return mav;
	}

	/**
	 * 스크롤 할 때 데이터 가져오기
	 * 
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "fetchList.do", method = RequestMethod.POST)
	@ResponseBody
	public String fetchList(@RequestParam(value = "eventSeq") int eventSeq,
			@RequestParam(value = "maxImgSeq") int maxImgSeq, @RequestParam(value = "num") int num)
			throws ParseException {

		Search search = new Search(eventSeq, num, 5);
		search.setSearchSeqSub(maxImgSeq);

		List<EventImgVO> list = eventImgService.doSelectList(search);

		// vo list -> JSON Array
		Gson gson = new Gson();

		@SuppressWarnings("deprecation")
		JSONParser jParser = new JSONParser();
		JSONArray jArr = new JSONArray();
		jArr = (JSONArray) jParser.parse(gson.toJson(list));
		LOG.debug("jArr: " + jArr);

		return jArr.toJSONString();
	}

	/**
	 * 이미지 업로드 후 json으로 응답
	 * 
	 * @param mReg
	 * @return json
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "doInsert.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(MultipartHttpServletRequest mReg,
			HttpSession session,
			@RequestParam String eventSeq,
			@RequestParam String isThumbnail) throws IllegalStateException, IOException {

		if (session.getAttribute("user") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("user");
			String regId = memberVO.getUserId();

			int flag = filesInsert(mReg, regId, Integer.parseInt(eventSeq), isThumbnail);
			LOG.debug("flag : " + flag);
			return responseJson(flag);
		}

		return responseJson(0);
	}

	/**
	 * 이미지 수정
	 * 
	 * @param mReg
	 * @return json
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "doUpdate.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doUpdate(MultipartHttpServletRequest mReg,
			HttpSession session,
			@RequestParam String eventSeq,
			@RequestParam String imgSeq,
			@RequestParam String isThumbnail) throws IllegalStateException, IOException {

		int flagDel = this.eventImgService.doDelete(Integer.parseInt(imgSeq));
		LOG.debug("flag after del : " + flagDel);


		if (session.getAttribute("user") != null) {
			MemberVO memberVO = (MemberVO) session.getAttribute("user");
			String regId = memberVO.getUserId();

			int flagInsert = filesInsert(mReg, regId, Integer.parseInt(eventSeq), isThumbnail);
			LOG.debug("flag after insert : " + flagInsert);
			return responseJson(flagDel + flagInsert);
		}

		return responseJson(0);
	}

	private int filesInsert(MultipartHttpServletRequest mReg, String regId, int eventSeq, String isThumbnail)
			throws IllegalStateException, IOException {
		LOG.debug("-----------------------");
		LOG.debug("filesInsert()");
		LOG.debug("-----------------------");

		// --- 이미지 저장 경로 설정
		File fileRootDir = new File(UPLOAD_FILE_DIR);
		if (fileRootDir.isDirectory() == false) {
			boolean flag = fileRootDir.mkdir();
			LOG.debug("[fileRootDir 생성] " + flag);
		}

		List<EventImgVO> list = new ArrayList<>();
		List<MultipartFile> imgList = mReg.getFiles("images[]");

		for (MultipartFile mf : imgList) {
			LOG.debug(mf.getName());
		}

		int flag = 0;

		for (MultipartFile mf : imgList) {

			// 원래 이름
			String orgImgNm = mf.getOriginalFilename();
			if (orgImgNm.equals("") || orgImgNm == null) {
				continue;
			}
			LOG.debug("[orgFileNm] " + orgImgNm);

			// 서버에 저장될 이름
			String saveImgNm = StringUtil.getPK("yyyyMMddHHmmss");
			LOG.debug("[saveFileNm]" + saveImgNm);

			// 확장자
			String ext = "";
			if (orgImgNm.indexOf(".") > -1) {
				ext = orgImgNm.substring(orgImgNm.lastIndexOf(".") + 1);
				LOG.debug("[확장자] " + ext);
				// saveImgNm += "." + ext;
			}

			// 사이즈 long -> int
			int size = (int) mf.getSize();
			LOG.debug("[파일크기] " + size);
			ImgVO imgVO = new ImgVO(126, orgImgNm, saveImgNm, ext, size, isThumbnail, "regDt", regId);
			LOG.debug("[imgVO] " + imgVO);

			// param - imgSeq, eventSeq, imgVO
			EventImgVO eventImgVO = new EventImgVO(126, eventSeq, imgVO);
			LOG.debug("[eventImgVO] " + eventImgVO);

			// 저장 파일 full path
			File fullPathFile = new File(fileRootDir, saveImgNm + "." + ext);
			LOG.debug("[fullPathFile] " + fullPathFile);
			LOG.debug("[full Path] " + fullPathFile.getAbsoluteFile());

			list.add(eventImgVO);
			mf.transferTo(new File(fullPathFile.getAbsolutePath()));
			LOG.debug("[full path]" + fullPathFile.getAbsolutePath());

			flag += eventImgService.doInsert(eventImgVO);
		}

		return flag;
	}

	private String responseJson(int flag) {
		Message message = new Message();
		message.setMsgId(String.valueOf(flag));

		if (flag > 0) {
			message.setMsgContents("이미지가 등록되었습니다.");
		} else {
			message.setMsgContents("이미지 등록을 실패했습니다.");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("[json] " + json);
		return json;
	}

	/**
	 * view.do -> 이미지 업로드 페이지 맵핑
	 * 
	 * @return img_upload.jsp
	 */
	@RequestMapping(value = "view.do")
	public String view() {
		LOG.debug("-------------------");
		LOG.debug("view()");
		LOG.debug("-------------------");

		return "img_upload";
	}

}
