package com.uver.dao;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uver.vo.memberVO;

//메소드 수행 순서:
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		
})

public class TestMemberDao {
	Logger LOG = Logger.getLogger(TestMemberDao.class);
	
	@Autowired
	memberDao dao;
	
	@Autowired
	ApplicationContext context;
	
	memberVO member01;
	memberVO member02;
	memberVO member03;
	
	@Test
	public void test() {
		dao.doInsert(member01);
		dao.doInsert(member02);
		dao.doInsert(member03);
	}

	
	
	@Before
	public void setUp() {
		member01=new memberVO("H170_01","최현우_01","1234","dotori130@naver.com",01012344321,"19900130",1,"스릴러");
		member02=new memberVO("H170_02","최현우_02","1234","dotori130@naver.com",01012344221,"19900130",1,"코믹");
		member03=new memberVO("H170_03","최현우_03","1234","dotori130@naver.com",01012342321,"19900130",1,"멜로");
		LOG.debug("** setup() **");
		LOG.debug("***********************************");
		LOG.debug("context"+context);
	 
	}
	
	
}
