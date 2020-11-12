package com.uver.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("MainController")
public class MainController {
	private static final Logger LOG = LoggerFactory.getLogger(EventImgController.class);

	
	//--- 메인페이지로 이동
	//------ 세션ID 여부에 따라 분기 main.jsp or main_user.jsp로 분기
	@RequestMapping(value="main.do")
	public String goMain(HttpServletRequest req) {
		LOG.debug("-------------------");
		LOG.debug("main page()");
		LOG.debug("-------------------");
		
		HttpSession session = req.getSession();
		if(session.getAttribute("user") != null) {
			return "index_after_login";
		} else {
			return "index";
		}
	}
	
	
	//--- 로그인 페이지로 이동
	@RequestMapping(value="login.do")
	public String goLogin() {
		LOG.debug("-------------------");
		LOG.debug("login()");
		LOG.debug("-------------------");
		
		//--- 추후 views 폴더에 main.jsp 페이지 설정
		return "login";
	}
			
	//--- 회원가입 페이지로 이동
	@RequestMapping(value="signup.do")
	public String goSignup() {
		LOG.debug("-------------------");
		LOG.debug("signup()");
		LOG.debug("-------------------");
		
		//--- 추후 views 폴더에 main.jsp 페이지 설정
		return "signup";
	}
	
	//--- 이벤트 view 페이지로 이동
	@RequestMapping(value="event_view.do")
	public String goEventView() {
		LOG.debug("-------------------");
		LOG.debug("eventView()");
		LOG.debug("-------------------");
		
		//--- 추후 views 폴더에 main.jsp 페이지 설정
		return "event_view";
	}
	
	//--- 이벤트 등록 페이지로 이동
	@RequestMapping(value="event_reg.do")
	public String goEventReg() {
		LOG.debug("-------------------");
		LOG.debug("eventReg()");
		LOG.debug("-------------------");
		
		//--- 추후 views 폴더에 main.jsp 페이지 설정
		return "event_reg";
	}
	
	//--- my event 이동
	@RequestMapping(value="my_event.do")
	public String goMyEvent() {
		LOG.debug("-------------------");
		LOG.debug("goMyEvent()");
		LOG.debug("-------------------");
		
		//--- 추후 views 폴더에 main.jsp 페이지 설정
		return "my_event";
	}

	//--- event_update 이동
	@RequestMapping(value="event_update.do")
	public String goEventUpdate() {
		LOG.debug("-------------------");
		LOG.debug("goEventUpdate()");
		LOG.debug("-------------------");
		
		//--- 추후 views 폴더에 main.jsp 페이지 설정
		return "event_update";
	}
	
	
	
	

}
