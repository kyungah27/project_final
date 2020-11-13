package com.uver.dao;

import java.util.HashMap;

import com.uver.vo.LikeVO;

public interface LikeDao {
	public int countLike(HashMap hashMap);

	/* 좋아요 번호 등록 */
	public int doInsert(HashMap hashMap);

	/**
	 * 좋아요 체크 여부 (0 -> 1)
	 * 
	 * @param hashMap
	 * @return
	 */
	public int likeCheck(HashMap hashMap);

	/**
	 * 좋아요 체크 취소 (1 -> 0)
	 * 
	 * @param hashMap
	 * @return
	 */
	public int likeCheckCancel(HashMap hashMap);

	/* 조회 */
	public LikeVO read(HashMap hashMap);

	/* 게시판의 좋아요 삭제 */
	public int deleteCommentSeq(int commentSeq);

	/* 회원의 좋아요 삭제 */
	public int deletebyMno(int memberSeq);

}
