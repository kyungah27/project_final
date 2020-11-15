package com.uver.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
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

import com.uver.cmn.Search;
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
    ImgDaoImpl dao;
    
    ImgVO img01;
    ImgVO img02;
    
    Search search;
    
    @Before
	public void setUp() throws Exception {
    	LOG.debug("---setup()---------------------------");
		LOG.debug("[context] " + context);
		LOG.debug("[imgDao] " + dao);
    	
		
		//---시퀀스, 원래이름, 서버이름, 타입, 크기(int), 썸네일여부, 등록일, 등록id
    	img01 = new ImgVO(1, "originName01", "serverName01", "png", 10, "y", "2020-08-08", "regId01");
    	img02 = new ImgVO(2, "originName02", "serverName02", "png", 10, "y", "2020-08-08", "regId02");
    	
    	search = new Search("regId01", 2, 5);
    	
    	LOG.debug("---parameters---------------------");
    	LOG.debug("[img01] " + img01);
    	LOG.debug("[img02] " + img02);
    	LOG.debug("[search] " + search);
    	LOG.debug("-----------------------");
	}
    
	
	@Test
	@Ignore
	public void test() {
		LOG.debug("---test---");

//		int img01Seq = dao.doInsert(img01);
//		int img02Seq = dao.doInsert(img02);
//		int flag = dao.doDelete(img01Seq);
//		flag += dao.doDelete(img02Seq);
//		LOG.debug("[시퀀스 번호 재설정] " + (img02Seq + 1));
	}
	
	
	
	@Test
	@Ignore
	public void addAndGet() {
		//---[전체 테스트]
		
		//---추가 & 단건 조회
		int img01Seq = dao.doInsert(img01);
		int img02Seq = dao.doInsert(img02);
		
		//---추가 데이터 null 체크
		assertThat(dao.doSelectOne(img01Seq), is(notNullValue()));
		assertThat(dao.doSelectOne(img02Seq), is(notNullValue()));
		
		//---전체 목록 조회
		doSelectList();
		
		//---수정		
		updateImg();
		
		//---삭제
		int flagDel = dao.doDelete(img01Seq);
		flagDel += dao.doDelete(img02Seq);
		assertThat(flagDel, is(2));
	}
	
	
	private void doSelectList() {
		List<ImgVO> list = dao.doSelectList(search);
	}
	
	private void updateImg() {
		int seq = dao.doInsert(img01);
		
		//---썸네일 여부 변경
    	int flag = dao.doUpdate(img01);
    	assertThat(flag, is(1));
		
		dao.doDelete(seq);
	}
	
			
	@After
	public void tearDown() throws Exception {	
    	LOG.debug("---tearDown()----------------------");
	}
	
	
	
	/*
	private void checkImg (ImgVO inVO, ImgVO vsVO) {
    	assertThat(inVO.getOriginName(), is(vsVO.getOriginName()));
    	assertThat(inVO.getServerName(), is(vsVO.getServerName()));
    	assertThat(inVO.getImgType(), is(vsVO.getImgType()));
    	assertThat(inVO.getImgSize(), is(vsVO.getImgSize()));
    	assertThat(inVO.getIsThumbnail(), is(vsVO.getIsThumbnail()));
    	assertThat(inVO.getRegId(), is(vsVO.getRegId()));
    }
    */
}
