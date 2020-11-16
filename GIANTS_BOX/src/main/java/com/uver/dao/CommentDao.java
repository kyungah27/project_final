package com.uver.dao;

import java.util.List;

import com.uver.vo.CommentVO;

public interface CommentDao {

	// -----메서드
	int doInsert(CommentVO comment);

	int doDelete(CommentVO comment);

	int doUpdate(CommentVO comment);

	CommentVO doSelectOne(int comment_seq);

	List<CommentVO> doSelectList(CommentVO comment);

	int likeCntUp(CommentVO comment);

	int likeCntDown(CommentVO comment);
}