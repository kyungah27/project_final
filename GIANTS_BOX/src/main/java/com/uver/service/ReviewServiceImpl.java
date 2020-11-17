package com.uver.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uver.cmn.Search;
import com.uver.dao.ReviewDao;
import com.uver.dao.ReviewDaoImpl;
import com.uver.vo.ReviewVO;

	@Service("ReviewServiceImpl")
	public class ReviewServiceImpl implements ReviewService {
	private static final Logger LOG = LoggerFactory.getLogger(ReviewServiceImpl.class);

	@Autowired
	ReviewDao reviewDao;

	public ReviewServiceImpl() {
	}

	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	@Override
	public int doInsert(ReviewVO reviewVO) {
		return reviewDao.doInsert(reviewVO);
	}

	@Override
	public int doDelete(ReviewVO reviewVO) {
		return reviewDao.doDelete(reviewVO);
	}

	@Override
	public int doUpdate(ReviewVO reviewVO) {
		return reviewDao.doUpdate(reviewVO);
	}

	

	
	@Override
	public ReviewVO doSelectOneByTitle(ReviewVO review) {
		return reviewDao.doSelectOneByTitle(review);
	}
	
	
	@Override
	public List<ReviewVO> doSelectList(Search search) {
		return reviewDao.doSelectList(search);
	}

	@Override
	public ReviewVO doSelectOne(ReviewVO reviewVO) {
		
		return reviewDao.doSelectOne(reviewVO);
	}
	
	
	
	
}
