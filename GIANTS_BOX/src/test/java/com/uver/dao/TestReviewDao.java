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

	@Autowired
	ApplicationContext context;

	ReviewVO review01;
	ReviewVO review02;

	
	@Before
	public void setUp() throws Exception {
		LOG.debug("** setup() **");
		LOG.debug("***************************************");
		LOG.debug("** context **" + context);
		LOG.debug("** ReviewDaoImpl **" + reviewDao);
		review01 = new ReviewVO(88, 1002,"김가람", "랄랄라", "11월", "", 10, "");
		review02 = new ReviewVO(89, 2, "최규연", "인터페이스", "오류", "",20, "");

		LOG.debug("[review01] " + review01);
		LOG.debug("[review02] " + review02);
		LOG.debug("***************************************");

	}
	
	@Test
	@Ignore
	public void addAndGet() {
		
		reviewDao.doDelete(review01);
		reviewDao.doDelete(review02);
		
		
		reviewDao.doInsert(review01);
		reviewDao.doInsert(review02);
				
	}
	
	
	@Test
	//@Ignore
	public void test() {
		int flag = 0;
		// 삽입		
		/*
		flag = reviewDao.doInsert(review01);
		assertThat(flag, is(1));
		flag = reviewDao.doInsert(review02);
		assertThat(flag, is(1));
		*/
		
		// 삭제
		/*
		flag = reviewDao.doDelete(review01);		
		assertThat(flag, is(1));		
		flag = reviewDao.doDelete(review02);
		assertThat(flag, is(1));
		*/
		
		
		// 수정	
		
		flag = reviewDao.doUpdate(review01);		
		ReviewVO updateVO = new ReviewVO(86, 1002, "장아네스", "수정중", "이벤트 모올라U", "",20, "");
		flag = reviewDao.doUpdate(updateVO);
		assertThat(flag, is(1));		
		
		
		
		// 단건조회	 
		//dao.doSelectOne(review01.getReview_seq());
		
		// 리스트 조회
		/*
		ReviewVO review = new ReviewVO();
		review.setEventSeq(1002);
		review.setDiv(10);

		List<ReviewVO> list = dao.doSelectList(review);
		assertThat(list.size(), is(5));

		// 입력데이터와 비교
		checkReview(review01, list.get(0));
		checkReview(review02, list.get(1));
		*/
		
		
	}//test
		 
		 @Test
		  @Ignore
		    public void doUpdate() throws ClassNotFoundException, SQLException {			 
			 
		    	//1.기존데이터 삭제
			 //dao.doDelete(review01);
			 //dao.doDelete(review02);
		    	
		    	
		    	//2.단건입력
		    	//int flag =dao.doInsert(review01);
			 	int flag =reviewDao.doUpdate(review01);
		    	assertThat(1, is(1));
		    	//3.수정
				review01=new ReviewVO(49, 1002, "저장해요", "이벤트 날씨U", "이벤트 모올라U", "",20, "");//BASIC
				//review01=new ReviewVO((review01.getReview_seq()), (review01.getEventSeq()), "", "", "", "","","");
				//review01.setReview_seq(review01.getReview_seq());
				review01.setEventSeq(review01.getEventSeq());
		    	review01.setWriter(review01.getWriter()+"_U");
		    	review01.setTitle(review01.getTitle()+"_U(title)");
		    	review01.setContext(review01.getContext()+"_U(context)");
		    	review01.setDiv(review01.getDiv());
		    	
		    	
		    	flag = reviewDao.doUpdate(review01);
		    	LOG.debug("flag:"+flag);
		    	assertThat(1, is(1));	    	 	
		    	
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
		 assertThat(inVO.getDiv(), is(vsVO.getDiv()));		
		assertThat(inVO.getMod_dt(), is(vsVO.getMod_dt()));
	}
}
