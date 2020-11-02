package com.uver.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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

import com.uver.vo.CommentVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) // 스프랭 테스트 컨텍스트 프레임워크의 JUnit기능 확장
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TestCommentDao {
	Logger LOG = Logger.getLogger(TestCommentDao.class);

	@Autowired
	CommentDaoImpl dao;

	@Autowired
	ApplicationContext context;

	CommentVO comment01;
	CommentVO comment02;

	// ---테스트 전 시퀀스 번호 확인 (nextval)
	int seq = 1;

	@Before
	public void setUp() throws Exception {
		LOG.debug("** setup() **");
		LOG.debug("***************************************");
		LOG.debug("** context **" + context);
		LOG.debug("** CommentDaoImpl **" + dao);
		comment01 = new CommentVO(seq, seq + 1, "10", "재밌었어요", "2020-11-01", "ehgml", "2020-11-01");
		comment02 = new CommentVO(seq + 10, seq + 11, "10", "재밌었어요2", "2020-11-01", "ehgml2", "2020-11-01");

		LOG.debug("[comment01] " + comment01);
		LOG.debug("[comment02] " + comment02);
		LOG.debug("***************************************");

	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("** tearDown() **");
		LOG.debug("***************************************");
	}

	@Test
	public void test() {
		LOG.debug("JUnit test");
	}

	private void checkComment(CommentVO inVO, CommentVO vsVO) {
		assertThat(inVO.getCommentSeq(), is(vsVO.getCommentSeq()));
		assertThat(inVO.getSeq(), is(vsVO.getSeq()));
		assertThat(inVO.getDiv(), is(vsVO.getDiv()));
		assertThat(inVO.getContent(), is(vsVO.getContent()));
		assertThat(inVO.getRegDt(), is(vsVO.getRegDt()));
		assertThat(inVO.getRegId(), is(vsVO.getRegId()));
		assertThat(inVO.getModDt(), is(vsVO.getModDt()));
	}
}
