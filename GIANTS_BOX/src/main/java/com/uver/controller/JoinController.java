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
import com.uver.cmn.Message;
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
	public String joinView() {
		LOG.debug("===================");
		LOG.debug("==joinView() ==");
		LOG.debug("===================");
		
		return "join/join_list";
	}
	
	@RequestMapping(value = "movieInfo/movie_info.do")
	public String movieInfoView() {
		LOG.debug("===================");
		LOG.debug("==movieInfoView() ==");
		LOG.debug("===================");
		
		return "movieInfo/movie_info";
	}
	
	@RequestMapping(value="join/doSelectList.do",method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8"
			)
	@ResponseBody
	public String doSelectList(JoinVO vo) {

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
	
	@RequestMapping(value="join/Kick.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8"
			)
	@ResponseBody
	public String Kick(JoinVO vo) {

		LOG.debug("join/Kick.do");
		
		Message message=new Message();
		//세션에서 가져올 예정
		JoinVO loginedVO = new JoinVO(1001,27,1);
		
		int flag = joinService.kickMember(loginedVO, vo);
        message.setMsgId(String.valueOf(flag));
        
        if(flag > 0) {
        	message.setMsgContents("추방 되었습니다.");
        }else {
        	message.setMsgContents("추방 실패했습니다.");
        }
		
		Gson gson = new Gson();
		String json = gson.toJson(message);
        LOG.debug("[json] "+json);
		return json;
	}
	
	
	@RequestMapping(value="join/Ban.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8"
			)
	@ResponseBody
	public String Ban(JoinVO vo) {

		LOG.debug("join/Ban.do");
		
		Message message=new Message();
		//세션에서 가져올 예정
		JoinVO loginedVO = new JoinVO(1001,27,1);
		
		int flag = joinService.banMember(loginedVO, vo);
        message.setMsgId(String.valueOf(flag));
        
        if(flag > 0) {
        	message.setMsgContents("차단 되었습니다.");
        }else {
        	message.setMsgContents("차단 실패했습니다.");
        }
		
		Gson gson = new Gson();
		String json = gson.toJson(message);
        LOG.debug("[json] "+json);
		return json;
	}
	
	
	
	
	

}
