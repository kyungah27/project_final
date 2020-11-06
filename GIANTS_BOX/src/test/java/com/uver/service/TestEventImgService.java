package com.uver.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.uver.cmn.Search;
import com.uver.vo.EventImgVO;
import com.uver.vo.ImgVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                               "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		
})
public class TestEventImgService {
	private static final Logger LOG = LoggerFactory.getLogger(TestEventImgService.class);

	@Autowired
    WebApplicationContext  context;
    
    @Autowired
    EventImgService service;
    
    ImgVO img01;
    ImgVO img02;
    private List<EventImgVO> eventImgList;
    Search search;
    Search searchById;
    
    @Before
    public void setUp() {
    	LOG.debug("---setup()---------------------------");
		
		img01 = new ImgVO(1, "originName01", "serverName01", "png", 10, "y", "2020-08-08", "regId01");
		img02 = new ImgVO(2, "originName02", "serverName02", "png", 10, "y", "2020-08-08", "regId02");
		
		eventImgList = Arrays.asList(
				new EventImgVO(1, 2, img01),
				new EventImgVO(2, 2, img02),
				new EventImgVO(3, 3, img01)
		);
		
		search = new Search(2, 1, 5);
		searchById = new Search("regId01", 1, 10);
		
		for (EventImgVO vo : eventImgList) {
			LOG.debug("[List] " + vo);
		}
    	LOG.debug("----------------------------------");
    }

//    @Test
//    @Ignore
    public void test() {
		LOG.debug("---test---");
	}
    
    
    
    
    
    @Test
//    @Ignore
    public void add() {
    	
    	//---등록
    	int flagIn = service.doInsert(eventImgList.get(0));
		LOG.debug("[flagIn] " + flagIn);
		assertThat(flagIn, is(1));
		
		//---등록 후 객체 얻기
		EventImgVO outVO = service.addAndGet(eventImgList.get(0));
		int imgSeq = outVO.getImgSeq();
		
		//---수정
		int flagUp = service.doUpdate(imgSeq);
		assertThat(flagUp, is(1));
		assertThat(service.doSelectOne(imgSeq).getImgVO().getIsThumbnail(), is("n"));

		//---삭제
		int flagDel = service.doDelete(outVO.getImgSeq());
		assertThat(flagDel, is(1));
		
		//---다건조회 by eventSeq
		List<EventImgVO> list = service.doSelectList(search);
    	
    	//---다건조회 by regId
		List<ImgVO> listById = service.doSelectListById(searchById);
    }

    
    
    private void bean() {
    	LOG.debug("----------------------------------");
    	LOG.debug("bean()");
    	LOG.debug("[context] " + context);
		LOG.debug("[EventImgService] " + service);
    	LOG.debug("----------------------------------");
		
		assertThat(context, is(notNullValue()));
		assertThat(service, is(notNullValue()));
    }
    
    @After
	public void tearDown() throws Exception {
		LOG.debug("---tearDown()---");		
	}
    
    
	
}
