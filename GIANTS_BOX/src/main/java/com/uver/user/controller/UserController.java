package com.uver.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uver.user.dao.User;
import com.uver.user.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	
	@RequestMapping(value="user/doInsert.do", method = RequestMethod.POST
			,produces = "application/json;chaset=UTF-8")
	@ResponseBody
	public int doInsert(User user) {
		int flag = 0;
		
			
		
		return flag;
	}
	
	
	
	
	
	
	
	
	

}
