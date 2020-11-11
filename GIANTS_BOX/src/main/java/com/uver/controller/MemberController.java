package com.uver.controller;

import java.sql.SQLException;

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
import com.uver.service.MemberService;
import com.uver.vo.MemberVO;

	@Controller("MemberController")
	public class MemberController {
		private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);

		private final MemberService memberService;
	
		public MemberController(MemberService memberService) {
		
		this.memberService = memberService;
	}
	
	
		  /**
		    * 회원가입
		    * @param inputUser
		    * @return
		 * @throws SQLException 
		 * @throws ClassNotFoundException 
		    */
		   @RequestMapping(value = "regUser.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		   @ResponseBody
		   public String regMember(MemberVO inputUser) throws ClassNotFoundException, SQLException {
			   	  
			      int regpwflag = 0;
			      
			      LOG.debug("-----------------------");
			      LOG.debug("MemberController_regMember");
			      LOG.debug("-----------------------");
			      
			      
			      regpwflag =memberService.regPw(inputUser);
			      LOG.debug("regpwflag:"+regpwflag);
			      
			      Message message = new Message();
			      if(regpwflag ==1 ) {
			    	  LOG.debug("regpwflag Success");
			    	  memberService.regMember(inputUser);
			    	  message.setMsgContents("회원가입에 성공하였습니다.");
			    	  
			    	  
			      }else{
			    	  message.setMsgContents("비밀번호를 확인해주세요.");
			    	  
			    	  
		   		  }  
			      message.setMsgId(regpwflag+"");
			      Gson gson = new Gson();
			      String json = gson.toJson(message);
			      LOG.debug("[json] " + json);
			      return json;
		   }
		   
		   
		   
		   

		   /**
		    * 로그인
		    * @param inputUser
		    * @return
		    */
		   @RequestMapping(value = "loginn.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		   @ResponseBody
		   public String idLogin(MemberVO inputUser) {

		      LOG.debug("-----------------------");
		      LOG.debug("login()");
		      LOG.debug("-----------------------");

		      MemberVO outVO = memberService.login(inputUser);
		      Message message = new Message();
		      if (outVO != null) {
		         message.setMsgContents("로그인에 성공하였습니다.");
		      } else {
		         message.setMsgContents("로그인에 실패했습니다..");
		      }
		      Gson gson = new Gson();
		      String json = gson.toJson(message);
		      LOG.debug("[json] " + json);
		      return json;
		   }



}