package com.uver.service;

import java.util.List;

import com.uver.vo.CommentVO;

public interface CommentService {
	/**
	 * 
	 * @param commentVO
	 * @return
	 */
	public int doInsert(CommentVO commentVO);

	/**
	 * 
	 * @param commentVO
	 * @return
	 */
	public int doDelete(CommentVO commentVO);

	/**
	 * 
	 * @param commentVO
	 * @return
	 */
	public int doUpdate(CommentVO commentVO);

	/**
	 * 
	 * @param comment_seq
	 * @return
	 */
	public CommentVO doSelectOne(int comment_seq);

	/**
	 * 
	 * @param commentVO
	 * @return
	 */
	public List<CommentVO> doSelectList(CommentVO commentVO);
}
