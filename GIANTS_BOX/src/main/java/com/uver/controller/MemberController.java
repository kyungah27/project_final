package com.uver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.uver.cmn.Message;
import com.uver.service.MemberServiceImpl;

	@Controller("MemberController")
	public class MemberController {
		private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);

		private final MemberServiceImpl memberService;
	
		public MemberController(MemberServiceImpl memberService) {
		
		this.memberService = memberService;
	}
	
	



		@RequestMapping(value="login.do", method=RequestMethod.POST
				,produces = "application/json;charset=UTF-8")
		@ResponseBody
		public String Login(MultipartHttpServletRequest mReg) {
			int flag = 0;
			
			LOG.debug("-----------------------");
			LOG.debug("login()");
			LOG.debug("-----------------------");
			
			
			Message message=new Message();
	        message.setMsgId(String.valueOf(flag));
	
			Gson gson = new Gson();
			String json = gson.toJson(message);
			LOG.debug("[json] "+json);
			return json;
		}


}