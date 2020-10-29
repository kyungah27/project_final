package com.uver.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.uver.vo.ImgVO;

  
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) //스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestImgDao {
	private static final Logger LOG = LoggerFactory.getLogger(TestImgDao.class);

	@Autowired
    WebApplicationContext  context;
    
    @Autowired
    ImgDao imgDao;
    
    ImgVO img01;
    ImgVO img02;
    ImgVO img03;
    
    
    @Before
	public void setUp() throws Exception {
    	LOG.debug("---setup()---------------------------");
		LOG.debug("[context] " + context);
		LOG.debug("[imgDao] " + imgDao);
    	
		//---원래이름, 서버이름, 타입, 크기(int), 썸네일여부, 등록id
    	img01 = new ImgVO("originName01", "serverName01", "png", 10, "y","regId01");
    	img02 = new ImgVO("originName02", "serverName02", "png", 10, "y", "regId02");
    	img03 = new ImgVO("originName03", "serverName03", "png", 10, "y", "regId03");
    	
    	LOG.debug("[img01] " + img01);
    	LOG.debug("[img02] " + img02);
    	LOG.debug("[img03] " + img03);
    	LOG.debug("----------------------------------");
	}
    
	
	@Test
	@Ignore
	public void test() { LOG.debug("---test---"); }
	
	@Test
//	@Ignore
	public void addAndGet() {
		
		//---1. 삭제
		
		//---2. 추가
		int flag = imgDao.doInsert(img01);
		assertThat(flag, is(1));
		
		
		
		//---3. 단건조회
		
		//------3-1. 조회 데이터 검증
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@After
	public void tearDown() throws Exception {	
    	LOG.debug("---tearDown()----------------------");
	}

}
