package com.uver.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
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
	ReviewDao dao;

	@Autowired
	ApplicationContext context;

	ReviewVO review01;
	ReviewVO review02;

	@Before
	public void setUp() throws Exception {
		LOG.debug("** setup() **");
		LOG.debug("***************************************");
		LOG.debug("** context **" + context);
		LOG.debug("** ReviewDaoImpl **" + dao);
		review01 = new ReviewVO(1, "정진미", "제목:블랙미러 본 후기", "내용:sf", "", 10, "");
		review02 = new ReviewVO(2, "곽경아", "신과함께 본 후기", "따흐흑 슬퍼", "",20, "");

		LOG.debug("[review01] " + review01);
		LOG.debug("[review02] " + review02);
		LOG.debug("***************************************");

	}

	@Test
	public void test() {
		int flag = 0;
		// 삭제
		// dao.doDelete(review01);
		// dao.doDelete(review02);

		// 삽입
		 //flag = dao.doInsert(review01);
		 //assertThat(flag, is(1));
		 //flag = dao.doInsert(review02);
		 //assertThat(flag, is(1));

		// 수정		 
		//ReviewVO updateVO = new ReviewVO(1, "곽호정", "제목:블랙미러 본 후기(수정)", "내용:sf(수정)", "", 10, "");
		//flag = dao.doUpdate(updateVO);
		//assertThat(flag, is(1));
		 
		 
		 //@Test
		  //@Ignore
		   /*
		    public void doUpdate() throws ClassNotFoundException, SQLException {
		    	//1.기존데이터 삭제
		    	ReviewDao.doDelete(review01);
		    	ReviewDao.doDelete(review02);
		    	
		    	
		    	//2.단건입력
		    	int flag =reviewDao.doInsert(review01);
		    	assertThat(1, is(1));
		    	//3.수정:이름,비번 수정
				//user01=new User("H10_01","강사_01","1234",Level.BASIC,1,0,"jamesol@paran.com","");//BASIC
		    	review01.setWriter(review01.getWriter()+"_U");
		    	review01.setTitle(review01.getTitle()+"_U(title)");
		    	review01.setContext(review01.getContext()+"_U(context)");
		    	
		    	
		    	flag = reviewDao.doUpdate(review01);
		    	assertThat(1, is(1));
		    	//4.단건조회
		    	//cntUser.setU_id("H10_0");
		    	ReviewVO updateVO = reviewDao.doSelectOne(review01.getTitle());//제목으로 조회?
		    	
		    	//5.수정과 단건조회 비교.
		    	checkReview(review01, updateVO);		    	
		    	
		    } 
		 */
		 

		// 단건조회 안되는거
		// ReviewVO vsVO = dao.doSelectOne(updateVO);
		// checkReview(updateVO, vsVO);
		// ReviewVO test = new ReviewVO();

		// 단건조회 성공
		 dao.doSelectOne(review01.getReview_seq());
		 
		 
		// 리스트 조회
		//ReviewVO review = new ReviewVO();
		//review.setReview_seq(2);
		//review.setDiv(10);

		//List<ReviewVO> list = dao.doSelectList(review);
		//assertThat(list.size(), is(5));

		// 입력데이터와 비교
		//checkReview(review01, list.get(0));
		//checkReview(review02, list.get(1));
	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("** tearDown() **");
		LOG.debug("***************************************");
	}

	private void checkReview(ReviewVO inVO, ReviewVO vsVO) {
		// assertThat(inVO.getCommentSeq(), is(vsVO.getCommentSeq()));
		//assertThat(inVO.getReview_seq(), is(vsVO.setReview_seq()));
		//assertThat(inVO.getDiv(), is(vsVO.getDiv()));
		//assertThat(inVO.getContext(), is(vsVO.getContext()));
		// assertThat(inVO.getReg_dt(), is(vsVO.getReg_dt()));
		//assertThat(inVO.getWriter(), is(vsVO.setWriter()));
		// assertThat(inVO.getModDt(), is(vsVO.getModDt()));
	}
}
