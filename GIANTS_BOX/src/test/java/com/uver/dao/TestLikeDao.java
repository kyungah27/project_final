package com.uver.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

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

import com.uver.vo.LikeVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class) // application context 공유를 위함
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })

public class TestLikeDao {
	final Logger LOG = LoggerFactory.getLogger(TestLikeDao.class);
	@Autowired // 테스트 컨택스트 프레임워크는 일치하는 컨텍스트를 찾아 DI해 준다.
	WebApplicationContext context;
	@Autowired
	LikeDaoImpl likeDaoImpl;
	LikeVO like01;
	LikeVO like02;

	@Before
	public void setUp() throws Exception {
		like01 = new LikeVO(1, 2, 1, 1);
	}

	@Test
	public void countLike() {
		like01.setLikeNo(1);
		LOG.debug("=context=" + like01);
	}

	/*
	 * public void doInsert() { int flag = likeDaoImpl.doInsert(hashMap); flag =
	 * likeDaoImpl.doInsert(like02); assertThat(flag, is(1)); }
	 */
	
	@Test
	public void beans() {
		LOG.debug("====================");
		LOG.debug("=context=" + context);
		LOG.debug("=likeDaoImpl=" + likeDaoImpl);
		LOG.debug("====================");
		assertThat(context, is(notNullValue()));
		assertThat(likeDaoImpl, is(notNullValue()));
	}

	private void checkLike(LikeVO orgLike, LikeVO vsLike) {
		assertThat(orgLike.getLikeNo(), is(vsLike.getLikeNo()));
		assertThat(orgLike.getCommentSeq(), is(vsLike.getCommentSeq()));
		assertThat(orgLike.getMemberSeq(), is(vsLike.getMemberSeq()));
		assertThat(orgLike.getLikeCheck(), is(vsLike.getLikeCheck()));
	}
}
