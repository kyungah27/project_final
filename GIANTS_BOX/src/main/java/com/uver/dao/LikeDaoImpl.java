package com.uver.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uver.vo.LikeVO;

@Repository
public class LikeDaoImpl {
	final Logger LOG = LoggerFactory.getLogger(LikeDaoImpl.class);
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	private final String NAMESPACE = "com.uver";

	public LikeVO doSelectOne(LikeVO likeVO) {
		LOG.debug("==================");
		LOG.debug("doSelectOne");
		LOG.debug("==================");

		// 단건조회: namespace+id=com.sist.ehr.board.doSelectOne
		String statement = NAMESPACE + ".doSelectOne";
		LOG.debug("statement" + statement);
		LOG.debug("likeVO" + likeVO);

		LikeVO outVO = this.sqlSessionTemplate.selectOne(statement, likeVO);
		LOG.debug("outVO" + outVO);
		return outVO;
	}

	public int doDelete(LikeVO likeVO) {
		LOG.debug("==================");
		LOG.debug("doDelete");
		LOG.debug("==================");

		// .중요
		String statement = NAMESPACE + ".doDelete";
		LOG.debug("statement" + statement);
		LOG.debug("likeVO" + likeVO);
		int flag = sqlSessionTemplate.delete(statement, likeVO);

		return flag;
	}

	public int doInsert(LikeVO likeVO) {
		LOG.debug("==================");
		LOG.debug("doInsert");
		LOG.debug("==================");

		// .중요
		String statement = NAMESPACE + ".doInsert";
		LOG.debug("statement" + statement);
		LOG.debug("likeVO" + likeVO);
		int flag = sqlSessionTemplate.insert(statement, likeVO);

		return flag;
	}
}
