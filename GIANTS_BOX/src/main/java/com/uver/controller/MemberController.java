package com.uver.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		
		@RequestMapping(value = "accunt.do")
		public String fileView() {
			LOG.debug("===================");
			LOG.debug("==fileView() ==");
			LOG.debug("===================");
			
			return "account";
		}
		
		
	
		/**
		 * 회원정보수정
		 * @param inputUser
		 * @return
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		@RequestMapping(value = "updateUser.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		   @ResponseBody
		   public String myUpdate(MemberVO inputUser) {
			
			LOG.debug(inputUser.getUserId());
			
		   int updateFlag = 0;
		   
		   updateFlag = memberService.myUpdate(inputUser);
		   
		   Message message = new Message();
			
			if(updateFlag == 1) {
				message.setMsgContents("회원정보가 수정되었습니다.");
			}else {
				message.setMsgContents("수정할 정보를 다시 확인해주세요");
			}
			
			 message.setMsgId(updateFlag+"");
		      Gson gson = new Gson();
		      String json = gson.toJson(message);
		      LOG.debug("[json] " + json);
		      
		      return json;
		    
		 }
		
		/**
		 * ID 중복 확인
		 * @param inputUser
		 * @return
		 * @throws ClassNotFoundException
		 * @throws SQLException
		 */
		@RequestMapping(value = "checkId.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		   @ResponseBody
		   public String idCheck(MemberVO inputUser) {
			int idcheckflag = 0;
			
			idcheckflag = memberService.idCheck(inputUser);
			
			Message message = new Message();
			
			if(idcheckflag == 1) {
				message.setMsgContents("ID 사용이 가능합니다.");
			}else {
				message.setMsgContents("이미 존재하는 ID입니다.");
			}
			
			 message.setMsgId(idcheckflag+"");
		      Gson gson = new Gson();
		      String json = gson.toJson(message);
		      LOG.debug("[json] " + json);
		      return json;
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
		   public String idLogin(MemberVO inputUser, HttpServletRequest req) {

		      LOG.debug("-----------------------");
		      LOG.debug("login()");
		      LOG.debug("-----------------------");

		      MemberVO outVO = memberService.login(inputUser);
		      Message message = new Message();
		      if (outVO != null) {
		         message.setMsgContents("로그인에 성공하였습니다.");
		         
		        // MemberVO user = (MemberVO) memberService.doSelectOne(inputUser);
		       //session 객체 생성
		         HttpSession session = req.getSession();
		         //session 생성
		         session.setAttribute("user", outVO.getUserId());
		      } else {
		         message.setMsgContents("로그인에 실패했습니다..");
		         
		      }
		      Gson gson = new Gson();
		      String json = gson.toJson(message);
		      LOG.debug("[json] " + json);
		      return json;
		   }
		   
		   /**
		    * 로그아웃
		    * @param inputUser
		    * @return
		    */
			public void logout(HttpSession session) {
		
				session.invalidate();
			}




}