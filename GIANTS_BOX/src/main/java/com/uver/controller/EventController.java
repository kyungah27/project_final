package com.uver.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.uver.cmn.Message;
import com.uver.cmn.Search;
import com.uver.cmn.StringUtil;
import com.uver.service.EventImgService;
import com.uver.service.EventService;
import com.uver.service.JoinService;
import com.uver.vo.EventVO;
import com.uver.vo.JoinVO;
import com.uver.vo.MemberVO;

@Controller("EventController")
public class EventController {

	// event_reg.jsp -> 이벤트 등록
	// event_list.jsp -> 이벤트 목록
	// event_view.jsp -> 이벤트 상세조회
	// event_mng.jsp -> 이벤트 수정/삭제/단건조회..!

	private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

	@Autowired
	EventService eventService;
	
	@Autowired
	JoinService joinService;

	@Autowired
	EventImgService eventImgService;


	@Autowired
	MessageSource messageSource;

	public EventController() {
	}

	@RequestMapping(value = "event/event_view.do", method = RequestMethod.GET)
	public String eventView() {

		return "event/event_reg";
	}

	
	
	
	//--- event_update 이동
	@RequestMapping(value="event_update.do", method=RequestMethod.GET)
	public ModelAndView goEventUpdate(@RequestParam("eventSeq") int eventSeq) {
		LOG.debug("-------------------");
		LOG.debug("goEventUpdate()");
		LOG.debug("-------------------");
		
		EventVO inVO = new EventVO();
		inVO.setEventSeq(eventSeq);
		
		EventVO outVO = this.eventService.doSelectOne(inVO);
		int imgSeq = this.eventImgService.doSelectThumbnail(eventSeq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("event", outVO);
		mav.addObject("imgSeq", imgSeq);
		mav.setViewName("event_update");
		return mav;
	}
	
	
	
	//--- event insert 하기
	@RequestMapping(value="event/doInsert.do",
			method = RequestMethod.POST,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doInsert(@RequestBody EventVO event) {
		LOG.debug("=================");
		LOG.debug("=event=" + event);
		LOG.debug("=================");
		
		int seq = this.eventService.doInsertGetSeq(event);
		LOG.debug("=================");
		LOG.debug("=seq="+seq);
		LOG.debug("=================");

		// 메시지 처리
		Message message = new Message();

		message.setMsgId("eventSeq");
		
		if(seq > 0) {
			message.setMsgContents(seq+"");
		} else {
			message.setMsgContents("등록 실패");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");

		return json;
	}


	@RequestMapping(value = "event/doDelete.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(EventVO event) {
		LOG.debug("=================");
		LOG.debug("=event=" + event);
		LOG.debug("=================");
		int flag = this.eventService.doDelete(event);

		// 메시지 처리
		Message message = new Message();
		message.setMsgId(flag + "");

		if (flag == 1) {
			message.setMsgContents(event.getEventSeq() + "삭제");
		} else {
			message.setMsgContents(event.getEventSeq() + "삭제 실패");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");

		return json;
	}

	@RequestMapping(value = "event/doUpdate.do",
			method = RequestMethod.POST,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doUpdate(@RequestBody EventVO event) {
		LOG.debug("==================");
		LOG.debug("=event=" + event);
		LOG.debug("==================");

		int flag = this.eventService.doUpdate(event);
		LOG.debug("==================");
		LOG.debug("=flag=" + flag);
		LOG.debug("==================");

		Message message = new Message();
		message.setMsgId(String.valueOf(flag));

		if (flag == 1) {
			message.setMsgContents("수정되었습니다.");
		} else {
			message.setMsgContents("수정 실패");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");
		return json;
	}
	
	
	
	

	@RequestMapping(value = "event/doSelectOne.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String doSelectOne(Model model , HttpServletRequest req) {
		LOG.debug("==================");
		  int memberSeq = 0;
		  HttpSession session = req.getSession();
		  if(session.getAttribute("user") !=null) {
			  MemberVO memberVO =(MemberVO)session.getAttribute("user");
			  LOG.debug(memberVO.toString());
			  memberSeq =  memberVO.getSeq();
		  }
	

		  String seletedSeq = (String) req.getParameter("seleted_seq");
		
		  EventVO inVO = new EventVO();
		  inVO.setEventSeq(Integer.parseInt(seletedSeq));
		  EventVO outVO = this.eventService.doSelectOne(inVO);
		  
		  
		  JoinVO joinVO = new JoinVO();
		  joinVO.setEventSeq(Integer.parseInt(seletedSeq));
		  joinVO.setMemberSeq(memberSeq);
		  int joinCheck = joinService.checkJoin(joinVO);
		  List<JoinVO> joinList = joinService.doSelectList(joinVO);
		  int joinCount = joinList.size();
		  model.addAttribute("joinCount", joinCount);
		  model.addAttribute("joinCheck", joinCheck);
		  
		  
		  String movieId  =outVO.getMovieInfo().substring(0,1);
		  String movieSeq  = outVO.getMovieInfo().substring(1);
		  model.addAttribute("movieId", movieId);
		  model.addAttribute("movieSeq", movieSeq);
		  model.addAttribute("eventVO", outVO);
		

		  return "event_view";
	}

	@RequestMapping(value = "event/doSelectList.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doSelectList(HttpServletRequest req) {
		LOG.debug("doSelectList");
		String searchWord = (String) req.getParameter("searchWord");
		LOG.debug(searchWord);
		String tmpStr = (String) req.getParameter("searchDate");
		String searchDate = tmpStr.replaceAll("-", "");
		LOG.debug(searchDate);
		String genreStr = (String) req.getParameter("genreStr");
		LOG.debug(genreStr);
		
		Search search = new Search("10", searchWord, searchDate, 10, 1);
		String [] genreArr = genreStr.split(",");
	
		for(int i = 0 ; i< genreArr.length ; i++) {
			
			search.addGenreList(genreArr[i]);
		}
		
		LOG.debug("search.toString()" + search.toString());
		
		
		// 페이지 num 기본값 처리
		if (search.getPageNum() == 0) {
			search.setPageNum(1);
		}

		// 페이지 사이즈 기본값 처리
		if (search.getPageSize() == 0) {
			search.setPageSize(10);
		}

		// 검색구분
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv(), ""));

		// 검색어
		search.setSearchWord(StringUtil.nvl(search.getSearchWord(), ""));
		LOG.debug("2==================");
		LOG.debug("=null처리 search=" + search);
		LOG.debug("==================");

		List<EventVO> list = this.eventService.doSelectList(search);
		if (list.size() > 0) {
			req.getSession().setAttribute("tot", list.get(0).getTotalCnt());
		}
		Gson gson = new Gson();

		String json = gson.toJson(list);
		LOG.debug("3==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");

		return json;
	}

}
