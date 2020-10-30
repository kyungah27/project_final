package com.uver.dao;

import static org.junit.Assert.*;

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

import com.uver.vo.EventVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) //스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestEventDao {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired //테스트 컨텍스트 프레임워크는 일치하는 컨텍스트를 찾아 DI해 준다.
    WebApplicationContext  context ;
	
	@Autowired
	EventDaoImpl eventDao;
	
	EventVO event01;
	EventVO event02;
	EventVO event03;
	
	@Before
	public void setUp() {
		event01 = new EventVO(100,"test_01","test_01","test_01",15,"test_01","20/10/30","20/10/30","test_01","","");
		event02 = new EventVO(200,"test_02","test_02","test_02",15,"test_02","20/10/30","20/10/30","test_02","","");
		event03 = new EventVO(300,"test_03","test_03","test_03",15,"test_03","20/10/30","20/10/30","test_03","","");
	}
	
	@Test
	public void addAndGet() {
		eventDao.doInsert(event01);
		eventDao.doInsert(event02);
		eventDao.doInsert(event03);
	}
	
	@Test
	@Ignore
	public void bean() {
		fail("Not yet implemented");
	}

}
