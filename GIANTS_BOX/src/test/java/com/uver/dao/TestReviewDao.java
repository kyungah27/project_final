package com.uver.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
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
		review01 = new ReviewVO(1, 2, "제목:블랙미러 본 후기", "SF내용이당", "김영롱", "", "");
		review02 = new ReviewVO(2, 4, "신과함께 본 후기", "따흐흑 슬퍼", "곽경아", "", "");

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
		 flag = dao.doInsert(review01);
		 assertThat(flag, is(1));
		 flag = dao.doInsert(review02);
		 assertThat(flag, is(1));

		// 수정
		// ReviewVO updateVO = new ReviewVO(24, 2, "신과함께 본 후", "재밌었다", "곽호정", "", "");
		// flag = dao.doUpdate(updateVO);
		// assertThat(flag, is(1));

		// 단건조회 안되는거
		// ReviewVO vsVO = dao.doSelectOne(updateVO);
		// checkReview(updateVO, vsVO);
		// ReviewVO test = new ReviewVO();

		// 단건조회 성공
		// dao.doSelectOne(review01.getReview_seq());

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
		assertThat(inVO.getDiv(), is(vsVO.getDiv()));
		assertThat(inVO.getContext(), is(vsVO.getContext()));
		// assertThat(inVO.getReg_dt(), is(vsVO.getReg_dt()));
		//assertThat(inVO.getWriter(), is(vsVO.setWriter()));
		// assertThat(inVO.getModDt(), is(vsVO.getModDt()));
	}
}
