package com.uver.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
import org.springframework.web.context.WebApplicationContext;

import com.uver.vo.EventImgVO;
import com.uver.vo.ImgVO;

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
    EventImgDaoImpl dao;
    
    @Autowired
    ImgDaoImpl imgDao;
    
    EventImgVO eventImg01;
    EventImgVO eventImg02;
    ImgVO img01;
    ImgVO img02;

	@Before
	public void setUp() throws Exception {
		LOG.debug("---setup()---------------------------");
		LOG.debug("[context] " + context);
		LOG.debug("[EventImgDao] " + dao);
		
		img01 = new ImgVO(240, "originName01", "serverName01", "png", 10, "y", "2020-08-08", "regId01");
		img02 = new ImgVO(241, "originName02", "serverName02", "png", 10, "y", "2020-08-08", "regId02");
		
		//---이미지 시퀀스, 이벤트 시퀀스
		
    	
    	LOG.debug("[eventImg01] " + eventImg01);
    	LOG.debug("[eventImg02] " + eventImg02);
    	LOG.debug("----------------------------------");
	}

//	@Test
//	@Ignore
	public void test() {
		LOG.debug("---test()---");
	}
	
	@Test
//	@Ignore
	public void addAndGet() {
		//---[전체 테스트]
		int img01Seq = imgDao.doInsert(img01);
		int img02Seq = imgDao.doInsert(img02);
		
		eventImg01 = new EventImgVO(img01Seq, 2, img01);
		eventImg02 = new EventImgVO(img02Seq, 2, img02);
		
		//---추가
		int flag = dao.doInsert(eventImg01);
		flag += dao.doInsert(eventImg02);
		assertThat(flag, is(2));
		
		//---단건 조회
		doSelectOne();
		
		//---다건 조회
		List<EventImgVO> list = dao.doSelectList(2);
		assertThat(dao.count(eventImg01.getEventSeq()), is(list.size()));
		
		
		//---삭제
		imgDao.doDelete(img01Seq);
		imgDao.doDelete(img02Seq);
		
	}
	
	
	public void doSelectOne() {
		//---단건 조회
		dao.doSelectOne(eventImg01.getImgSeq());
		dao.doSelectOne(eventImg02.getImgSeq());
	}
	
	
	@After
	public void tearDown() throws Exception {
		LOG.debug("---tearDown()---");		
	}

}
