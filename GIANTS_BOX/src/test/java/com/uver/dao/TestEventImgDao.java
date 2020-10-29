package com.uver.dao;

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
import org.springframework.web.context.WebApplicationContext;

import com.uver.vo.EventImgVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) //스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestEventImgDao {
	private static final Logger LOG = LoggerFactory.getLogger(TestEventImgDao.class);
	
	@Autowired
    WebApplicationContext  context;
    
    @Autowired
    EventImgDao dao;
    
    EventImgVO eventImg01;
    EventImgVO eventImg02;
    EventImgVO eventImg03;

	@Before
	public void setUp() throws Exception {
		LOG.debug("---setup()---------------------------");
		LOG.debug("[context] " + context);
		LOG.debug("[EventImgDao] " + dao);
    	
		
		
//		img01 = new ImgVO(seq, "originName01", "serverName01", "png", 10, "y", "2020-08-08", "regId01");
//		img02 = new ImgVO(seq+1, "originName02", "serverName02", "png", 10, "y", "2020-08-08", "regId02");
		
		//---이벤트 시퀀스, 이미지 시퀀스
		eventImg01 = new EventImgVO(1, 1);
		eventImg02 = new EventImgVO(1, 2);
		eventImg03 = new EventImgVO(2, 1);
    	
    	LOG.debug("[eventImg01] " + eventImg01);
    	LOG.debug("[eventImg02] " + eventImg02);
    	LOG.debug("[eventImg03] " + eventImg03);
    	LOG.debug("----------------------------------");
	}


	@Test
	@Ignore
	public void test() {
		LOG.debug("---test---");
	}
	
	@Test
//	@Ignore
	public void addAndGet() {
		
		//---추가
		
		
		
		
	}
	
	
	
	
	
	
	
	
	@After
	public void tearDown() throws Exception {
		
	}

}
