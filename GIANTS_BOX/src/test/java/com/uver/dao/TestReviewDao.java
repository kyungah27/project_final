package com.uver.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import com.uver.cmn.Search;
import com.uver.vo.ReviewVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) // 스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TestReviewDao {
	Logger LOG = Logger.getLogger(TestReviewDao.class);

	@Autowired
	@Qualifier("reviewDaoImpl")
	ReviewDao reviewDao;

	//추가함
	@Autowired
	ReviewDaoImpl reviewDaoImpl;
	
	@Autowired
	ApplicationContext context;

	ReviewVO review01;
	ReviewVO review02;
	ReviewVO review03;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("** setup() **");
		LOG.debug("***************************************");
		LOG.debug("** context **" + context);
		LOG.debug("** ReviewDaoImpl **" + reviewDao);
		review01 = new ReviewVO(1, 1002,"박민경", "나나", "로로로", "", "영화", "");
		review02 = new ReviewVO(1, 0, "서지은", "가가", "리리리", "","영화", "");
		review03 = new ReviewVO(1, 0, "김송이", "테스트", "니니니", "","후기", "");
		
		LOG.debug("[review01] " + review01);
		LOG.debug("[review02] " + review02);
		LOG.debug("[review03] " + review03);
		LOG.debug("***************************************");

	}
	
	@Test
	@Ignore
	public void addAndGet() {
		
		reviewDao.doDelete(review01);
		reviewDao.doDelete(review02);
		reviewDao.doDelete(review03);
		
		reviewDao.doInsert(review01);
		reviewDao.doInsert(review02);
		reviewDao.doInsert(review03);
	}
	
	
	@Test
	@Ignore
	public void test() {
		int flag = 0;
		// 삽입		
		
		flag = reviewDao.doInsert(review01);
		assertThat(flag, is(1));
		flag = reviewDao.doInsert(review02);
		assertThat(flag, is(1));
		flag = reviewDao.doInsert(review03);
		assertThat(flag, is(1));
		
		
		// 삭제
		/*
		flag = reviewDao.doDelete(review01);		
		assertThat(flag, is(1));		
		flag = reviewDao.doDelete(review02);
		assertThat(flag, is(1));
		flag = reviewDao.doDelete(review03);
		assertThat(flag, is(1));
		*/
		
		
		// 수정	
		/*
		flag = reviewDao.doUpdate(review01);		
		ReviewVO updateVO = new ReviewVO(86, 1002, "쪼꼼쓰", "수정중", "이벤트 모올라U", "",20, "");
		flag = reviewDao.doUpdate(updateVO);
		assertThat(flag, is(1));		
		
		flag = reviewDao.doUpdate(review01);		
		ReviewVO updateVO = new ReviewVO(86, 1002, "쪼꼼쓰", "수정중", "이벤트 모올라U", "",20, "");
		flag = reviewDao.doUpdate(updateVO);
		assertThat(flag, is(1));		
		
		flag = reviewDao.doUpdate(review01);		
		ReviewVO updateVO = new ReviewVO(86, 1002, "쪼꼼쓰", "수정중", "이벤트 모올라U", "",20, "");
		flag = reviewDao.doUpdate(updateVO);
		assertThat(flag, is(1));		
		
		*/
		
		
		// 단건조회
		/*
		reviewDao.doSelectOne(review01.getReview_seq());
		*/		
		
		//제목으로 단건조회
		/*
		reviewDao.doSelectOneByTitle(review01);
		*/
		
		
		// 리스트 조회
		/*
		Search search = new Search("50", "엄마", "", 10, 1);
		search.setDiv("10");
		//LOG.debug(search.getGenreList().toString());
		
		List<ReviewVO> list = reviewDao.doSelectList(search);
		*/
		
	}//test

	
	@Test
	//@Ignore
	public void doSelectList(){
		//1.all삭제
		//2.3건 입력
		//3.조회
		//4.3건비교
		
		//1.
		//this.reviewDaoImpl.doDeleteAll();
		
		//2.
		//int flag = reviewDaoImpl.doInsert(review01);
		//assertThat(flag, is(1));
		
		//flag = reviewDaoImpl.doInsert(review02);
		//assertThat(flag, is(1));
		
		//flag = reviewDaoImpl.doInsert(review03);
		//assertThat(flag, is(1));
		
		//Search search=new Search("40", "c",10,1);
		Search search=new Search("40", "최규연");
		//search.setDiv("10");
		
		List<ReviewVO> list = reviewDaoImpl.doSelectList(search);
		
		assertThat(list.size(), is(3));
		
	}
	
	@After
	public void tearDown() throws Exception {
		LOG.debug("** tearDown() **");
		LOG.debug("***************************************");
	}

	private void checkReview(ReviewVO inVO, ReviewVO vsVO) {
		
		assertThat(inVO.getReview_seq(), is(vsVO.getReview_seq()));
		assertThat(inVO.getEventSeq(), is(vsVO.getEventSeq()));
		assertThat(inVO.getWriter(), is(vsVO.getWriter()));
		assertThat(inVO.getTitle(), is(vsVO.getTitle()));
		assertThat(inVO.getContext(), is(vsVO.getContext()));
		 assertThat(inVO.getReg_dt(), is(vsVO.getReg_dt()));
		 assertThat(inVO.getCategory(), is(vsVO.getCategory()));		
		assertThat(inVO.getMod_dt(), is(vsVO.getMod_dt()));
	}
}
