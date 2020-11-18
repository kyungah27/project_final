package com.uver.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.uver.cmn.Message;
import com.uver.cmn.Search;
import com.uver.cmn.StringUtil;
import com.uver.dao.ReviewDaoImpl;
import com.uver.service.ReviewService;
import com.uver.vo.CommentVO;
import com.uver.vo.EventVO;
import com.uver.vo.ReviewVO;

	@Controller
	public class ReviewController {
		
		// review_write.jsp -> 리뷰 등록
		// review_list.jsp -> 리뷰 목록
	
		// review_mng.jsp -> 리뷰 읽기/수정/삭제/단건조회
		
		
	private static final Logger LOG = LoggerFactory.getLogger(ReviewController.class);

	@Autowired
	ReviewService reviewservice;

	@Autowired
	MessageSource  messageSource;
	
	public ReviewController() {
	}

	public ReviewController(ReviewService reviewservice) {
		this.reviewservice = reviewservice;
	}

	//기본화면
	//목록 화면을 기본화면으로 할 것
	@RequestMapping(value = "review/doSelectList.do", method = RequestMethod.GET)
	public String review_view() {
		LOG.debug("review_selectlist");
		
		return "review/review_selectlist";
	}
	

	
	@RequestMapping(value = "review/doInsert.do", method = RequestMethod.POST)
	@ResponseBody
	public Message doInsert(ReviewVO reviewVO,Locale locale) {
	    //servliet-context.xml -> <annotation-driven /> 
		//
		//HttpMessageConverter를 구현한 모든 변환기가 생성된다.
		LOG.debug("===================================");
		LOG.debug("=doInsert=");
		LOG.debug("=param="+reviewVO);
		
		//예외 발생!
		if(null == reviewVO.getTitle()) {
			//message.common.message.valid
			Object[] args01 = new String[] {"제목"};
			String msgTitleConfirm = this.messageSource.getMessage("message.common.message.valid", args01, locale);
			
			throw new IllegalArgumentException(msgTitleConfirm);
		}
		
		int  flag = reviewservice.doInsert(reviewVO);
		Message  message=new Message();
		message.setMsgId(String.valueOf(flag));
		if(flag>0) {
			Object[] args01 = new String[] {"등록"};
			String msgConfirm = this.messageSource.getMessage("message.common.message.confirm", args01, locale);
			//LOG.debug("=msgConfirm="+msgConfirm);
			message.setMsgContents(msgConfirm);
		}else {
			message.setMsgContents("등록 실패.");
		}
		
		LOG.debug("=message="+message);
		LOG.debug("===================================");		
		
		return message;
	}
	
	
	
	@RequestMapping(value="review/doSelectOne.do",method = RequestMethod.GET)
	public String doSelectOne(ReviewVO reviewVO,Locale locale,Model model) {
		//게시판 관리 화면
		String returnURL = "review/review_mng";
		LOG.debug("===================================");
		LOG.debug("=doSelectOne=");		
		LOG.debug("=doDelete=");
		LOG.debug("=param="+reviewVO);  
		
		if( 0==reviewVO.getReview_seq()) {
			throw new IllegalArgumentException("게시글 번호를 확인 하세요.");
		}
		
		ReviewVO outVO = this.reviewservice.doSelectOne(reviewVO);
		model.addAttribute("vo", outVO);
		
		return returnURL;
	}
	
	
	
	@RequestMapping(value="review/doSelectList.do",method = RequestMethod.GET)
	public String doSelectList(Search search,Model model) {
		//param초기화
				//pageSize, pageNum
				if(search.getPageNum()==0) {
					search.setPageNum(1);
				}
				
				if(search.getPageSize()==0) {
					search.setPageSize(10);
				}
				
				//게시구분 초기화: 공지사항,자유게시판
				if(search.getDiv()==null) {
					search.setDiv("10");//공지사항
				}		
				
				search.setSearchDiv(StringUtil.nvl(search.getSearchDiv(), ""));
				search.setSearchWord(StringUtil.nvl(search.getSearchWord(), ""));
				
				LOG.debug("=====================");
				LOG.debug("=1.param="+search);
				LOG.debug("=====================");
				
				//board_list화면으로 param전달
				model.addAttribute("vo", search);
				
				//조회목록:
				//서비스 호출: 화면에 전달
				List<ReviewVO> reviewList = this.reviewservice.doSelectList(search);
				model.addAttribute("list", reviewList);
				
				
				//총글수
				int totalCnt = 0;
				
				if(reviewList.size()>0) {
					ReviewVO totalVO = reviewList.get(0);
					totalCnt = totalVO.getTotalCnt();
				}
				model.addAttribute("totalCnt", totalCnt);
				
				
			    for(ReviewVO vo:reviewList) {
			    	LOG.debug(vo.toString());
			    }    
			    
				//code: PAGE_SIZE,BOARD_CONDITION
				
				
				String view = "review/review_list";
				//view화면
				return view;
	  	}
	
	
	@RequestMapping(value = "review/doUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public Message doUpdate(ReviewVO reviewVO, Locale locale) {
		//servliet-context.xml -> <annotation-driven /> 
		//
		//HttpMessageConverter를 구현한 모든 변환기가 생성된다.
		LOG.debug("===================================");
		LOG.debug("=doUpdate=");
		LOG.debug("=param="+reviewVO);
		
		//예외 발생!
		if(null == reviewVO.getTitle()) {
			//message.common.message.valid
			Object[] args01 = new String[] {"제목"};
			String msgTitleConfirm = this.messageSource.getMessage("message.common.message.valid", args01, locale);
			
			throw new IllegalArgumentException(msgTitleConfirm);
		}
		
		//예외 발생!
		if(null == reviewVO.getContext()) {
			//message.common.message.valid
			Object[] args01 = new String[] {"내용"};
			String msgTitleConfirm = this.messageSource.getMessage("message.common.message.valid", args01, locale);
			
			throw new IllegalArgumentException(msgTitleConfirm);
		}
		
		int  flag = reviewservice.doUpdate(reviewVO);
		Message  message=new Message();
		message.setMsgId(String.valueOf(flag));
		
		if(flag>0) {
			Object[] args01 = new String[] {"수정"};
			String msgConfirm = this.messageSource.getMessage("message.common.message.confirm", args01, locale);
			//LOG.debug("=msgConfirm="+msgConfirm);
			message.setMsgContents(msgConfirm);
		}else {
			message.setMsgContents("수정 실패.");
		}
		
		LOG.debug("=message="+message);
		LOG.debug("===================================");		
		
		return message;
	}
	
	
	@RequestMapping(value = "review/doDelete.do", method = RequestMethod.POST)
	public Message doDelete(ReviewVO reviewVO,Locale locale) {
		LOG.debug("===================================");
		LOG.debug("=doDelete=");
		LOG.debug("=param="+reviewVO);
		if( 0==reviewVO.getReview_seq()) {
			throw new IllegalArgumentException("게시글 번호를 확인 하세요.");
		}
		
		int flag = this.reviewservice.doDelete(reviewVO);
		Message message=new Message();
		message.setMsgId(String.valueOf(flag));
		
		if(flag>0) {
			Object[] args01 = new String[] {"삭제"};
			String msgConfirm = this.messageSource.getMessage("message.common.message.confirm", args01, locale);
			message.setMsgContents(msgConfirm);
		}else {
			message.setMsgContents("등록 실패.");
		}
				
		
		return message;
	}
	
	
	
	
	
	
	
	/*
	@RequestMapping(value = "review/doSelectOneById.do", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doSelectOneById(writer) throws ClassNotFoundException, SQLException {
		LOG.debug("==================");
		LOG.debug("=reviewVO=" + reviewVO);
		LOG.debug("==================");

		int flag = this.reviewservice.doSelectOneById(writer);
		LOG.debug("==================");
		LOG.debug("=flag=" + flag);
		LOG.debug("==================");

		// 메시지 처리
		Message message = new Message();
		message.setMsgId(flag + "");

		//제목으로 등록 알아보기
		if (flag == 1) {
			message.setMsgContents(reviewVO.getTitle() + " 이 조회되었습니다.");
		} else {
			message.setMsgContents(reviewVO.getTitle() + " 이 조회 실패되었습니다.");
		}

		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("==================");
		LOG.debug("=json=" + json);
		LOG.debug("==================");

		return json;
	}
	*/
}
