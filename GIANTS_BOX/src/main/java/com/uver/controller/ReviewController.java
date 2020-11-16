package com.uver.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.uver.cmn.Message;
import com.uver.cmn.Search;
import com.uver.cmn.StringUtil;
import com.uver.service.ReviewService;
import com.uver.vo.CommentVO;
import com.uver.vo.EventVO;
import com.uver.vo.ReviewVO;

	@Controller("ReviewController")
	public class ReviewController {
	private static final Logger LOG = LoggerFactory.getLogger(ReviewController.class);

	
	ReviewService reviewservice;

	public ReviewController() {
	}

	public ReviewController(ReviewService reviewservice) {
		this.reviewservice = reviewservice;
	}

	
	

	
	@RequestMapping(value = "review/doInsert.do", method = RequestMethod.POST, 
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(ReviewVO reviewVO) throws ClassNotFoundException, SQLException {
		LOG.debug("==================");
		LOG.debug("=reviewVO=" + reviewVO);
		LOG.debug("==================");

		int flag = this.reviewservice.doInsert(reviewVO);
		LOG.debug("==================");
		LOG.debug("=flag=" + flag);
		LOG.debug("==================");

		// 메시지 처리
		Message message = new Message();
		message.setMsgId(flag + "");

		//제목으로 등록 알아보기
		if (flag == 1) {
			message.setMsgContents(reviewVO.getTitle() + " 이 등록 되었습니다.");
		} else {
			message.setMsgContents(reviewVO.getTitle() + " 이 등록 실패되었습니다.");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");

		return json;
	}
	
	@RequestMapping(value = "review/doDelete.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(ReviewVO reviewVO) throws ClassNotFoundException, SQLException {
		LOG.debug("==================");
		LOG.debug("=reviewVO=" + reviewVO);
		LOG.debug("==================");

		int flag = this.reviewservice.doDelete(reviewVO);
		LOG.debug("==================");
		LOG.debug("=flag=" + flag);
		LOG.debug("==================");

		// 메시지 처리
		Message message = new Message();
		message.setMsgId(flag + "");

		//제목으로 등록 알아보기
		if (flag == 1) {
			message.setMsgContents(reviewVO.getTitle() + " 이 삭제 되었습니다.");
		} else {
			message.setMsgContents(reviewVO.getTitle() + " 이 삭제 실패되었습니다.");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");

		return json;
	}
	
	
	@RequestMapping(value = "review/doUpdate.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doUpdate(ReviewVO reviewVO) throws ClassNotFoundException, SQLException {
		LOG.debug("==================");
		LOG.debug("=reviewVO=" + reviewVO);
		LOG.debug("==================");

		int flag = this.reviewservice.doUpdate(reviewVO);
		LOG.debug("==================");
		LOG.debug("=flag=" + flag);
		LOG.debug("==================");

		// 메시지 처리
		Message message = new Message();
		message.setMsgId(flag + "");

		//제목으로 등록 알아보기
		if (flag == 1) {
			message.setMsgContents(reviewVO.getTitle() + " 이 수정 되었습니다.");
		} else {
			message.setMsgContents(reviewVO.getTitle() + " 이 수정 실패되었습니다.");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");

		return json;
	}
	
	/*
	@RequestMapping(value = "review/doSelectOneById.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doSelectOneById(writer) throws ClassNotFoundException, SQLException {
		LOG.debug("==================");
		LOG.debug("=reviewVO=" + reviewVO);
		LOG.debug("==================");

		int flag = this.reviewservice.doSelectOneById(writer);
		LOG.debug("==================");
		LOG.debug("=flag=" + flag);
		LOG.debug("==================");

		// 메시지 처리
		Message message = new Message();
		message.setMsgId(flag + "");

		//제목으로 등록 알아보기
		if (flag == 1) {
			message.setMsgContents(reviewVO.getTitle() + " 이 조회되었습니다.");
		} else {
			message.setMsgContents(reviewVO.getTitle() + " 이 조회 실패되었습니다.");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");

		return json;
	}
	*/
}
