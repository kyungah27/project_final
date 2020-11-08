package com.uver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.uver.cmn.Message;
import com.uver.service.MemberServiceImpl;
import com.uver.vo.MemberVO;

	@Controller("MemberController")
	public class MemberController {
		private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);

		private final MemberServiceImpl memberService;
	
		public MemberController(MemberServiceImpl memberService) {
		
		this.memberService = memberService;
	}
	
	
		@RequestMapping(value = "join/login_view.do")
		public String login() {
			LOG.debug("ssss");
			return "join/login_view";
		}


		@RequestMapping(value="login.do", method=RequestMethod.POST
				,produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String login(MemberVO membervo, MemberVO inputUser) {
			int flag = 0;
			
			LOG.debug("-----------------------");
			LOG.debug("login()");
			LOG.debug("-----------------------");
			
			MemberVO outVO = memberService.login(inputUser);
			
			ModelAndView mav = new ModelAndView();
			if(outVO == null) {
				mav.setViewName("test_page");
				flag = 1;
			}else{
				mav.setViewName("login_view");
				flag = 0;
			};
			
			
			Message message=new Message();
	        message.setMsgId(String.valueOf(flag));
	        
	        if(flag > 0) {
	        	message.setMsgContents("로그인에 성공하였습니다.");
	        }else {
	        	message.setMsgContents("로그인에 실패했습니다.");
	        }
	
			Gson gson = new Gson();
			String json = gson.toJson(message);
			LOG.debug("[json] "+json);
			return json;
		}


}