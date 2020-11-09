package com.uver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.uver.cmn.Message;
import com.uver.service.EventImgService;
import com.uver.service.EventService;
import com.uver.vo.EventImgVO;
import com.uver.vo.EventVO;
import com.uver.vo.ImgVO;

@Controller("EventController")
public class EventController {

	private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

	@Autowired
	EventService eventService;
	
	@Autowired
	EventImgService eventImgService;
	
	public EventController() {}
	
	@RequestMapping(value="event/event_reg.do",method=RequestMethod.GET)
	public String eventView() {
		
		return "event/event_reg";
	}

	@RequestMapping(value="event/doInsert.do",method = RequestMethod.POST
					,produces = "application/json;charset=UTF-8")
	public String doInsert(EventVO event) {
		
		
		LOG.debug("=================");
		LOG.debug("=event="+event);
		LOG.debug("=================");
		
		int flag = this.eventService.doInsert(event);
		LOG.debug("=================");
		LOG.debug("=flag="+flag);
		LOG.debug("=================");
		
		//메시지 처리
		Message message = new Message();
		message.setMsgId(flag+"");
		
		if(flag==1) {
			message.setMsgContents("새로운 모임이 등록되었습니다.");
		}else {
			message.setMsgContents("등록에 실패하였습니다.");
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
        LOG.debug("=json="+json);
        LOG.debug("=================="); 
        
        return json;
	}
}
