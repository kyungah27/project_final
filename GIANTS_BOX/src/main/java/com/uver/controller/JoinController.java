package com.uver.controller;

import java.util.ArrayList;
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

import com.google.gson.Gson;
import com.uver.service.JoinService;
import com.uver.vo.JoinMemberVO;
import com.uver.vo.JoinVO;

@Controller("JoinController")
public class JoinController {
	private static final Logger LOG = LoggerFactory.getLogger(EventImgController.class);
	
	@Autowired
	JoinService joinService;
	
	
	public JoinController() {
		
		
	}
	@RequestMapping(value = "join/join_view.do")
	public String fileView() {
		LOG.debug("===================");
		LOG.debug("==fileView() ==");
		LOG.debug("===================");
		
		return "join/join_list";
	}
	
	@RequestMapping(value="join/doSelectList.do",method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8"
			)
	@ResponseBody
	public String doSelectList(JoinVO vo) {
//		List<JoinVO> list = new ArrayList<JoinVO>();
//		
//		LOG.debug(vo.toString());
//		list = joinService.doSelectList(vo);
//		for(JoinVO tmpVO : list) {
//			LOG.debug("controller doSelectList  : "  +  tmpVO.toString());
//		}
//		
//		Gson gson=new Gson();    
//		String json = gson.toJson(list);
//		return json;
		
		List<JoinMemberVO> list = new ArrayList<JoinMemberVO>();
		
		LOG.debug(vo.toString());
		list = joinService.currentJoinList(vo);
		for(JoinMemberVO tmpVO : list) {
			LOG.debug("controller doSelectList  : "  +  tmpVO.toString());
		}
		
		Gson gson=new Gson();    
		String json = gson.toJson(list);
		return json;
		
	}
	
	
	
	
	

}
