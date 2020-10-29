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

import com.uver.vo.ImgVO;
import com.uver99.example.User;

  
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
    ImgDao dao;
    
    ImgVO img01;
    ImgVO img02;
    
    int seq = 18;
    
    @Before
	public void setUp() throws Exception {
    	LOG.debug("---setup()---------------------------");
		LOG.debug("[context] " + context);
		LOG.debug("[imgDao] " + dao);
    	
		//---시퀀스, 원래이름, 서버이름, 타입, 크기(int), 썸네일여부, 등록일, 등록id
    	img01 = new ImgVO(seq, "originName01", "serverName01", "png", 10, "y", "2020-08-08", "regId01");
    	img02 = new ImgVO(seq+1, "originName02", "serverName02", "png", 10, "y", "2020-08-08", "regId02");
    	
    	LOG.debug("[img01] " + img01);
    	LOG.debug("[img02] " + img02);
    	LOG.debug("----------------------------------");
	}
    
	
	@Test
	public void test() { LOG.debug("---test---"); }
	
	@Test
	@Ignore
	public void addAndGet() {
		
		//---1. 삭제
		int flagDel = dao.doDelete(img01);
		assertThat(flagDel, is(1));
		
		//---2. 추가
		int flagInsert = dao.doInsert(img02);
		assertThat(flagInsert, is(1));
		
		//---3. 단건조회
		ImgVO outVO = dao.doSelectOne(img02.getImgSeq());
		checkImg(img02, outVO);
	}
	
	@Test
	@Ignore
	public void getAll() {
		
		int flag = dao.doDelete(img01);
		flag += dao.doDelete(img02);

		flag += dao.doInsert(img01);
		flag += dao.doInsert(img01);
		seq = seq + flag;
		LOG.debug("[현재 시퀀스 번호] " + seq);
		
		dao.doSelectList(img01);
		int cnt = dao.count(img01);
		assertThat(cnt, is(2));
		
	}
	
	private void checkImg (ImgVO inVO, ImgVO vsVO) {
    	assertThat(inVO.getImgSeq(), is(vsVO.getImgSeq()));
    	assertThat(inVO.getOriginName(), is(vsVO.getOriginName()));
    	assertThat(inVO.getServerName(), is(vsVO.getServerName()));
    	assertThat(inVO.getImgType(), is(vsVO.getImgType()));
    	assertThat(inVO.getImgSize(), is(vsVO.getImgSize()));
    	assertThat(inVO.getIsThumbnail(), is(vsVO.getIsThumbnail()));
    	assertThat(inVO.getRegId(), is(vsVO.getRegId()));
    }
			
	@After
	public void tearDown() throws Exception {	
    	LOG.debug("---tearDown()----------------------");
	}
}
