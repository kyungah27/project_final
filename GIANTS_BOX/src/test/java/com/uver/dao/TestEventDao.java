package com.uver.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.intThat;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.uver.cmn.Search;
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
		
		LOG.debug("** setup() **");
    	LOG.debug("***************************************");
    	LOG.debug("** context **"+context);
    	LOG.debug("** eventDao **"+eventDao);
		
		event01 = new EventVO(10, "test_01", "새모임01", "새로운모임01", 15, "영화01", "", "", "서울", "", "2020-11-20 00:00:00","test_01","코미디");
		event02 = new EventVO(20, "test_02", "새모임02", "새로운모임02", 15, "영화02", "", "", "경기", "", "2020-11-20 00:00:00","test_02","공포");
		event03 = new EventVO(30, "test_03", "새모임03", "새로운모임03", 15, "영화03", "", "", "인천", "", "2020-11-20 00:00:00","test_03","드라마");
	}
	
	@Test
	@Ignore
	public void addAndGet() {
		
		eventDao.doDelete(event01);
		eventDao.doDelete(event02);
		eventDao.doDelete(event03);
		
		eventDao.doInsert(event01);
		eventDao.doInsert(event02);
		eventDao.doInsert(event03);
		
		
	}
	
	
	@Test
	@Ignore
	public void doSeletList() {
			
		Search search = new Search("10", "새모임", "20201113", 10, 1);
		//search.addGenreList("드라마");
		//search.addGenreList("공포");
		LOG.debug(search.getGenreList().toString());
		
		List<EventVO> list = eventDao.doSelectList(search);
	}
	
	@Test
	@Ignore
	public void doUpdate() {
		eventDao.doDelete(event01);
		eventDao.doDelete(event02);
		eventDao.doDelete(event03);
		
		int flag = eventDao.doInsert(event01);
		assertThat(1, is(1));
		
		event01.setUserId(event01.getUserId()+"_up");
		event01.setEventNm(event01.getEventNm()+"_up");
		event01.setContent(event01.getContent()+"_up");
		event01.setCapacity(20);
		event01.setMovieInfo(event01.getMovieInfo()+"_up");
		event01.setStartDt("201101");
		event01.setEndDt("201103");
		event01.setLocation(event01.getLocation()+"_up");
		event01.setTargetDt("201113");
		event01.setRegId(event01.getRegId()+"_up");
		event01.setGenre("액션");
		
		flag = eventDao.doUpdate(event01);
		assertThat(1, is(1));

	}
	
	@Test
	@Ignore
	public void doDelete() {
		event01.setEventSeq(10);
		int flag = eventDao.doDelete(event01);
		//event02.setEventSeq(20);
		//flag = eventDao.doDelete(event02);
		//event03.setEventSeq(30);
		//flag = eventDao.doDelete(event03);
		//assertThat(flag, is(1));
	}
	
	@Test
	//@Ignore
	public void doInsert() {
		int flag = eventDao.doInsert(event01);
		assertThat(flag, is(1));
		flag = eventDao.doInsert(event02);
		assertThat(flag, is(1));
		flag = eventDao.doInsert(event03);
		assertThat(flag, is(1));
	}
	
	@Test
	@Ignore
	public void doSelectOne() {
		event01.setEventSeq(10);
		EventVO outVO = eventDao.doSelectOne(event01);
	}
	
	

}
