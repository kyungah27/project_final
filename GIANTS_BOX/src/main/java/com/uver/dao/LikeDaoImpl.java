package com.uver.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uver.vo.CommentVO;


@Repository
public class LikeDaoImpl {
	final Logger LOG = LoggerFactory.getLogger(LikeDaoImpl.class);
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	private final String NAMESPACE = "com.uver";

	public int doInsert(CommentVO commentVO) {
		LOG.debug("==================");
		LOG.debug("doInsert");
		LOG.debug("==================");

		// .중요
		String statement = NAMESPACE + ".doInsert";
		LOG.debug("statement" + statement);
		LOG.debug("commentVO" + commentVO);
		int flag = sqlSessionTemplate.insert(statement, commentVO);

		return flag;
	}
}
