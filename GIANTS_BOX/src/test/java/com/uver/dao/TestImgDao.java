package com.uver.dao;

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

import com.uver.vo.ImgVO;

  
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) //스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                                   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class TestImgDao {
	private static final Logger LOG = LoggerFactory.getLogger(TestImgDao.class);

	@Autowired //테스트 컨텍스트 프레임워크는 일치하는 컨텍스트를 찾아 DI해 준다.
    WebApplicationContext  context;
    
    @Autowired
    ImgDao  imgDao;
    
    ImgVO img01;
    ImgVO img02;
    ImgVO img03;
    
    
    @Before
	public void setUp() throws Exception {
    	LOG.debug("----------------------------------");
    	LOG.debug("setup()");
    	LOG.debug("[context] "+context);
    	LOG.debug("[imgDao] "+imgDao);
    	LOG.debug("----------------------------------");
    	
//    	img01 = new ImgVO(1, "originName");
	}
	
	@Test
	@Ignore
	public void test() { LOG.debug("test"); }
	
	

}
