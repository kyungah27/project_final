package com.uver.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

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
import org.springframework.web.context.WebApplicationContext;

import com.uver.vo.JoinVO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) // 스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TestJoinDao {
	final static Logger   LOG = LoggerFactory.getLogger(TestJoinDao.class);
	
	@Autowired // 테스트 컨텍스트 프레임워크는 일치하는 컨텍스트를 찾아 DI해 준다.
	WebApplicationContext context;

	@Autowired
	JoinDaoImpl joinDao;
	
	JoinVO vo01;

	@Before
	public void setUp() throws Exception {
		vo01 = new JoinVO(2,3,0);
	}

	


	@Test
	public void doInsert() {
		int flag = joinDao.doInsert(vo01);
		assertThat(flag, is(1));
		
	}
	
	
	
	@Test
	public void bean() {
		
		LOG.debug("context"  + context);
		LOG.debug("joinDao"  + joinDao);
		assertThat(context, is(notNullValue()));
		assertThat(joinDao, is(notNullValue()));
	}

}
