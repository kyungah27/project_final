package com.uver.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uver.dao.LikeDao;
import com.uver.vo.LikeVO;

@Service("LikeServiceImpl")
public class LikeServiceImpl implements LikeServcie {
	private static final Logger LOG = LoggerFactory.getLogger(LikeServiceImpl.class);
	@Autowired
	LikeDao likeDao;

	public LikeServiceImpl() {
	}

	@Override
	public int countLike(LikeVO likeVO) {

		int count = likeDao.countLike(likeVO);
		return count;
	}

	@Override
	public int doInsert(LikeVO likeVO) {
		int count = likeDao.doInsert(likeVO);
		return count;
	}

	@Override
	public int likeCheck(LikeVO likeVO) {
		int count = likeDao.likeCheck(likeVO);
		return count;
	}

	@Override
	public int likeCheckCancel(LikeVO likeVO) {
		int count = likeDao.likeCheckCancel(likeVO);
		return count;
	}

	@Override
	public LikeVO read(LikeVO likeVO) {
		LikeVO VO = likeDao.read(likeVO);
		return VO;
	}

	@Override
	public int deleteCommentSeq(int commentSeq) {
		int count = likeDao.deleteCommentSeq(commentSeq);
		return count;
	}

	@Override
	public int deleteMemberSeq(int memberSeq) {
		int count = likeDao.deleteCommentSeq(memberSeq);
		return count;
	}

}
