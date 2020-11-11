package com.uver.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.uver.cmn.Message;
import com.uver.dao.EventDaoImpl;
import com.uver.service.EventService;
import com.uver.vo.EventVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) // 스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
	
public class TestEventController {
	
	final Logger LOG = LoggerFactory.getLogger(TestEventController.class);
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	List<EventVO> events;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	EventDaoImpl eventDaoImpl;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=================");
		LOG.debug("=setUp()=");
		events = Arrays.asList(new EventVO(10, "test_01", "새모임01", "새로운모임01", 15, "영화01", "", "", "서울", "", "20/11/13","test_01")
		 					  ,new EventVO(20, "test_02", "새모임02", "새로운모임02", 15, "영화02", "", "", "경기", "", "20/11/13","test_02")
		 					  ,new EventVO(30, "test_03", "새모임03", "새로운모임03", 15, "영화03", "", "", "인천", "", "20/11/13","test_03")
		 );
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		LOG.debug("=mockMvc=" + mockMvc);
		assertThat(mockMvc, is(notNullValue()));
		LOG.debug("=========================");
	}

	@Test
	public void doInsert() throws Exception {
		EventVO event = events.get(0);
		
		MockHttpServletRequestBuilder createMessage = 
				 MockMvcRequestBuilders.post("/event/doInsert.do")
				 .param("eventNm", event.getEventNm())
				 .param("userId", event.getUserId())
				 .param("capacity", event.getCapacity()+"")
				 .param("content", event.getContent())
				 .param("location", event.getLocation())
				 .param("startDt", event.getStartDt())
				 .param("endDt", event.getEndDt())
				 .param("targetDt", event.getTargetDt())
				 .param("regId", event.getRegId())
				 .param("movieInfo", event.getMovieInfo());
		
		ResultActions resultActions = mockMvc.perform(createMessage)
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(status().is2xxSuccessful());
				//.andExpect(jsonPath("$.msgId", is("1")));
		
		String result = resultActions.andDo(print()).andReturn().getResponse().getContentAsString();
		LOG.debug("===========================");
		LOG.debug("=result=" + result);
		LOG.debug("===========================");
		//json -> Message
		Gson gson=new Gson();
		
		Message outVO = gson.fromJson(result, Message.class);
		LOG.debug("===========================");
		LOG.debug("=Message=" + outVO);
		LOG.debug("===========================");	
		
		
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void beans() {
		LOG.debug("---------------------------");
		LOG.debug("webApplicationContext:" + webApplicationContext);
		LOG.debug("eventService:" + eventService);
		LOG.debug("---------------------------");
	
		assertThat(webApplicationContext, is(notNullValue()));
		assertThat(eventService, is(notNullValue()));
	}

}
