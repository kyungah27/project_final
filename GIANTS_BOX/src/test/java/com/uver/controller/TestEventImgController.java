package com.uver.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.uver.service.EventImgService;
import com.uver.vo.EventImgVO;

//메소드 수행 순서:
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TestEventImgController {
	public static final Logger LOG = (Logger) LoggerFactory.getLogger(TestEventImgController.class);
	
	@Autowired
	WebApplicationContext context;
	
	@Autowired
	EventImgService eventImgService;
	
	//브라우저 대용
	MockMvc mockMvc;
	
	List<EventImgVO> eventImgs;
	
	@Before
	public void setUp() {
		LOG.debug("----------------------");
		LOG.debug("setup()");
		
		eventImgs = Arrays.asList(
				
				
				);
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@After
	public void tearDown() {
		
	}
}
