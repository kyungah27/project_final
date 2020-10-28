package com.uver.user.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.uver.cmn.Message;
import com.uver.user.dao.User;
import com.uver.user.service.UserService;

@Controller
public class UserController {
	private static final Logger  LOG = LoggerFactory.getLogger(UserController.class);
	
	private final UserService  userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(value="user/doSelectOne.do", method=RequestMethod.GET
			,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String doSelectOne(User user) {
		LOG.debug("------------------------");
		LOG.debug("user: " + user);
		LOG.debug("------------------------");
		
		User outVO = userService.doSelectOne(user.getU_id());
		LOG.debug("------------------------");
		LOG.debug("outVO: " + outVO);
		LOG.debug("------------------------");
		
		Gson gson = new Gson();
		String json = gson.toJson(outVO);
		LOG.debug("------------------------");
		LOG.debug("json: " + json);
		LOG.debug("------------------------");
		
		return json;
	}
	
	
	
	@RequestMapping(value="user/doDelete.do", method=RequestMethod.GET
			,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(User user) {
		LOG.debug("------------------------");
		LOG.debug("user" + user);
		LOG.debug("------------------------");
		int flag = this.userService.doDelete(user);
	    LOG.debug("==================");
        LOG.debug("=flag="+flag);
        LOG.debug("==================");      
        
        //메시지 처리
        Message  message=new Message();
        message.setMsgId(flag+"");
        
        if(flag ==1 ) {
        	message.setMsgContents(user.getName()+" 님이 삭제 되었습니다.");
        }else {
        	message.setMsgContents(user.getName()+" 님 삭제 실패.");
        }
        
        Gson gson=new Gson();
        String json = gson.toJson(message);
        LOG.debug("==================");
        LOG.debug("=json="+json);
        LOG.debug("==================");         
        
		return json;
	}
	
	
	/**
	 * 1. controller에 view를 찾아 주는 메소드 생성
	 * 2. view submit->  controller에 데이터 전달.
	 * 3. controller에서 해당되는 view에 데이터 전달 
	 * @return
	 */
	@RequestMapping(value = "user_view.do",method = RequestMethod.GET)
	public String  user_view() {
		LOG.debug("====================");
		LOG.debug("=user_view=");
		LOG.debug("====================");
		///WEB-INF/views/user_view.jsp
		return "user_view";	
	}
	
	
	
	@RequestMapping(value = "user_view_json.do",method = RequestMethod.POST
			,produces ="application/json;charset=UTF-8")
	@ResponseBody
	public String  userViewJson(User user, Model model) {
		LOG.debug("====================");
		LOG.debug("=RequestMethod.POST=");
		LOG.debug("=user="+user);
		model.addAttribute("user", user);
		Gson  gson=new Gson();
		String json = gson.toJson(user);
		LOG.debug("=json="+json);
		return json;	
	}
	
	
	
	@RequestMapping(value = "user_view.do",method = RequestMethod.POST)
	//public String  userView(HttpServletRequest req, Model model) {
	public String  userView(User user, Model model) {
		LOG.debug("====================");
		LOG.debug("=RequestMethod.POST=");
		LOG.debug("=user="+user);
//		String uId = req.getParameter("u_id");
//		String name = req.getParameter("name");
//		String passwd = req.getParameter("passwd");
//		
//		LOG.debug("=uId="+uId);
//		LOG.debug("=name="+name);
//		LOG.debug("=passwd="+passwd);
		model.addAttribute("user", user);
		///WEB-INF/views/user_view.jsp
		return "user_view";	
	}
	
	
	@RequestMapping(value="user/doInsert.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8"
			)
	@ResponseBody
	public String doInsert(User user) throws ClassNotFoundException, SQLException {
        LOG.debug("==================");
        LOG.debug("=user="+user);
        LOG.debug("==================");
		
        int flag = this.userService.add(user);
        LOG.debug("==================");
        LOG.debug("=flag="+flag);
        LOG.debug("==================");      
        
        //메시지 처리
        Message  message=new Message();
        message.setMsgId(flag+"");
        
        if(flag ==1 ) {
        	message.setMsgContents(user.getName()+" 님이 등록 되었습니다.");
        }else {
        	message.setMsgContents(user.getName()+" 님 등록 실패.");
        }
        
        Gson gson=new Gson();
        String json = gson.toJson(message);
        LOG.debug("==================");
        LOG.debug("=json="+json);
        LOG.debug("==================");         
        
		return json;
	}
	

	
	
	
	
	
	
	
	
}

