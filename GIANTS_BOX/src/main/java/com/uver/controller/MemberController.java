package com.uver.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		@RequestMapping(value = "account.do")
		public String fileView() {
			LOG.debug("===================");
			LOG.debug("==fileView() ==");
			LOG.debug("===================");
			
			return "account";
		}
		
		
		 @RequestMapping(value = "deleteUser.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
		   @ResponseBody
		   public String idDelete(MemberVO inputUser, HttpSession session) {
			int flag = 0;
			 
			flag = memberService.idDelete(inputUser);
			 
					
			Message message = new Message();
			
			if(flag == 1) {
				message.setMsgContents("회원정보가 삭제되었습니다.");
				this.logout(session);
				
			}else {
				message.setMsgContents("수정할 정보를 다시 확인해주세요");
			}
			
			 message.setMsgId(flag+"");
		      Gson gson = new Gson();
		      String json = gson.toJson(message);
		      LOG.debug("[json] " + json);
		      
		      return json;
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
		   @RequestMapping(value = "loginn.do",
				   method = RequestMethod.GET,
				   produces = "application/json;charset=UTF-8")
		   @ResponseBody
		   public String idLogin(
				   @RequestParam("userId") String userId,
				   @RequestParam("password") String password,
				   HttpServletRequest req) {
			   
			   
		      LOG.debug("-----------------------");
		      LOG.debug("login()");
		      LOG.debug("-----------------------");
		      
		      MemberVO inVO = new MemberVO();
		      inVO.setUserId(userId);
		      inVO.setPassword(password);
		      LOG.debug("[inVO] "+ inVO);

		      MemberVO outVO = memberService.login(inVO);
		      Message message = new Message();
		      
		      if (outVO != null) {
		    	 message.setMsgId("1");
		         message.setMsgContents("로그인에 성공하였습니다.");
		         
		        // MemberVO user = (MemberVO) memberService.doSelectOne(inputUser);
		       //session 객체 생성
		         HttpSession session = req.getSession();
		         
		         MemberVO user = new MemberVO();
		         user.setSeq(outVO.getSeq());
		         user.setName(outVO.getName());
		         user.setCellPhone(outVO.getCellPhone());
		         user.setBirthday(outVO.getBirthday());
		         user.setGenre(outVO.getGenre());
		         user.setAuth(outVO.getAuth());
		         user.setEmail(outVO.getEmail());
		         user.setUserId(outVO.getUserId());
		         LOG.debug("[user] " + user);
		         
		         //session 생성 (MemberVO로 받기)
		         session.setAttribute("user", user);
		         LOG.debug("[session obj: user] " + session.getAttribute("user"));
		         
		         
		      } else {
		    	 message.setMsgId("0");
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