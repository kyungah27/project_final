package com.uver.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uver.vo.LikeVO;

@Repository("LikeDaoImpl")
public class LikeDaoImpl implements LikeDao {
	final Logger LOG = LoggerFactory.getLogger(LikeDaoImpl.class);

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	private final String NAMESPACE = "com.uver";

	public LikeDaoImpl() {
	}

	@Override
	public int countLike(LikeVO likeVO) {
		LOG.debug("countLike");
		String statement = NAMESPACE + ".countLike";
		int count = sqlSessionTemplate.selectOne("like.countLike", likeVO);
		return count;
	}

	@Override
	public int doInsert(LikeVO likeVO) {
		LOG.debug("doInsert");
		String statement = NAMESPACE + ".doInsert";
		int count = sqlSessionTemplate.insert("statement", likeVO);
		return count;
	}

	@Override
	public int likeCheck(LikeVO likeVO) {
		LOG.debug("likeCheck");
		String statement = NAMESPACE + ".likeCheck";
		int count = sqlSessionTemplate.update("statement", likeVO);
		return count;

	}

	@Override
	public int likeCheckCancel(LikeVO likeVO) {
		LOG.debug("likeCheckCancel");
		String statement = NAMESPACE + ".likeCheck";
		int count = sqlSessionTemplate.update("statement", likeVO);
		return count;

	}

	@Override
	public LikeVO read(LikeVO likeVO) {
		String statement = NAMESPACE + ".read";
		LikeVO VO = sqlSessionTemplate.selectOne("statement", likeVO);
		return VO;

	}

	@Override
	public int deleteCommentSeq(int commentSeq) {
		LOG.debug("deleteCommentSeq");
		String statement = NAMESPACE + ".deleteCommentSeq";
		int count = sqlSessionTemplate.delete("statement", commentSeq);
		return count;
	}

	@Override
	public int deleteMemberSeq(int memberSeq) {
		LOG.debug("deletebyMno");
		String statement = NAMESPACE + ".deletebyMno";
		int count = sqlSessionTemplate.delete("statement", memberSeq);
		return count;

	}
}
