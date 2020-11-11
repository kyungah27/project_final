package com.uver.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
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
import org.springframework.web.context.WebApplicationContext;

import com.uver.cmn.Search;
import com.uver.service.EventImgService;
import com.uver.vo.EventImgVO;
import com.uver.vo.ImgVO;

//메소드 수행 순서:
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TestEventImgController {
	private static final Logger LOG = LoggerFactory.getLogger(TestEventImgController.class);
	
	@Autowired
	WebApplicationContext context;
	
	@Autowired
	EventImgService eventImgService;
	
	//브라우저 대용
	MockMvc mockMvc;
	
	List<EventImgVO> eventImgs;
	ImgVO img01;
    ImgVO img02;
    Search search;
    Search searchById;
    
	@Before
	public void setUp() {
		LOG.debug("----------------------");
		LOG.debug("setup()");
		
		img01 = new ImgVO(1, "originName01", "serverName01", "png", 10, "y", "2020-08-08", "regId01");
		img02 = new ImgVO(2, "originName02", "serverName02", "png", 10, "y", "2020-08-08", "regId02");
		
		eventImgs = Arrays.asList(
				new EventImgVO(1, 2, img01),
				new EventImgVO(2, 2, img02)
		);
		
		search = new Search(2, 1, 5);
		search.setSearchSeqSub(eventImgService.getMaxImgSeq(2));
		searchById = new Search("regId01", 1, 10);
		
		for (EventImgVO vo : eventImgs) {
			LOG.debug("[List] " + vo);
		}
    	LOG.debug("----------------------------------");
	}
	
	
	@Test
	public void beans() {
		LOG.debug("---------------------------");
		LOG.debug("webApplicationContext:" + context);
		LOG.debug("userService:" + eventImgService);
		LOG.debug("---------------------------");

		assertThat(context, is(notNullValue()));
		assertThat(eventImgService, is(notNullValue()));
	}
	
	@After
	public void tearDown() {
		
	}
}
