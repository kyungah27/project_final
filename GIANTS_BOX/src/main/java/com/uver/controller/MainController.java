package com.uver.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uver.vo.MemberVO;

@Controller("MainController")
public class MainController {
	private static final Logger LOG = LoggerFactory.getLogger(EventImgController.class);

	//--- 리뷰페이지 이동
		@RequestMapping(value="review.do")
		public String goReview(HttpServletRequest req) {
			LOG.debug("-------------------");
			LOG.debug("review()");
			LOG.debug("-------------------");
			
			return "review";
		}
	
	
	//--- 메인페이지로 이동
	@RequestMapping(value="main.do")
	public String goMain(HttpServletRequest req) {
		LOG.debug("-------------------");
		LOG.debug("main()");
		LOG.debug("-------------------");
		
		if(isAliveSession(req)) {
			return "index_after_login";
		} else {
			return "index";
		}
	}
	
	//--- 로그아웃 처리
	@RequestMapping(value="logout.do")
	public String goLogout(HttpServletRequest req) {
		LOG.debug("-------------------");
		LOG.debug("goLogout()");
		LOG.debug("-------------------");
		
		req.getSession().invalidate();
		return "index";
	}
	
	//--- 로그인 페이지로 이동
	@RequestMapping(value="login.do")
	public String goLogin() {
		LOG.debug("-------------------");
		LOG.debug("login()");
		LOG.debug("-------------------");
		
		return "login";
	}
			
	//--- 회원가입 페이지로 이동
	@RequestMapping(value="signup.do")
	public String goSignup() {
		LOG.debug("-------------------");
		LOG.debug("signup()");
		LOG.debug("-------------------");
		
		return "signup";
	}
	
	//--- 1개 이벤트 페이지로 이동
	@RequestMapping(value="event_list.do")
	public String goEventList() {
		LOG.debug("-------------------");
		LOG.debug("goEventList()");
		LOG.debug("-------------------");
		
		return "event_list";
	}
	
	
	//--- 이벤트 등록 페이지로 이동
	@RequestMapping(value="event_reg.do")
	public String goEventReg() {
		LOG.debug("-------------------");
		LOG.debug("eventReg()");
		LOG.debug("-------------------");
		return "event_reg";
	}
	
	//--- my event 이동
	@RequestMapping(value="my_event.do")
	public String goMyEvent() {
		LOG.debug("-------------------");
		LOG.debug("goMyEvent()");
		LOG.debug("-------------------");
		
		return "my_event";
	}


	
	
	/**
	 * 로그인 세션 존재 여부 체크
	 * 존재하지 않을 시 세션 객체 무효화
	 * 
	 * @param HttpServletRequest req
	 * @return (true: 존재, false: 존재x)
	 */
	private boolean isAliveSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if(getMember(session) != null) {
			return true;
		} else {
			session.invalidate();
			return false;
		}
	}
	
	
	/**
	 * 세션에서 MemberVO 가져오기
	 * 
	 * @param session
	 * @return Object
	 */
	private MemberVO getMember(HttpSession session) {
		return (MemberVO) session.getAttribute("user");
		
	}
	

}
