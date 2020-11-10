package com.uver.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uver.dao.CommentDao;
import com.uver.dao.CommentDaoImpl;
import com.uver.vo.CommentVO;

@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {
	private static final Logger LOG = LoggerFactory.getLogger(CommentServiceImpl.class);

	@Autowired
	CommentDao commentDao;

	public CommentServiceImpl() {
	}

	public CommentServiceImpl(CommentDaoImpl commentDaoImpl) {

		this.commentDao = commentDao;
	}

	@Override
	public int doInsert(CommentVO commentVO) {
		return commentDao.doInsert(commentVO);
	}

	@Override
	public int doDelete(CommentVO commentVO) {
		return commentDao.doDelete(commentVO);
	}

	@Override
	public int doUpdate(CommentVO commentVO) {
		return commentDao.doUpdate(commentVO);
	}

	@Override
	public CommentVO doSelectOne(int comment_seq) {
		return commentDao.doSelectOne(comment_seq);
	}

	// 게시글 댓글이 1개 이상이면 댓글목록 반환
	@Override
	public List<CommentVO> doSelectList(CommentVO commentVO) {
		List<CommentVO> commentList = Collections.emptyList();

		int commentTotalCount = commentList.size();
		if (commentTotalCount > 0) {
			commentList = commentDao.doSelectList(commentVO);
		}
		return commentList;
		
		// 원래 리턴
		// return commentDao.doSelectList(commentVO);
	}

}
