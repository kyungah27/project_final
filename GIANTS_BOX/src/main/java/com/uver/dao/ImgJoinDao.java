package com.uver.dao;

import java.util.List;


public interface ImgJoinDao<T> {
	/**
	 * 이미지 등록
	 * 
	 * @param T
	 */
	int doInsert(T vo);

	/**
	 * 다건 조회
	 * 
	 * @param int eventSeq
	 * @return List<T>
	 */
	List<T> doSelectList(int seq);

	/**
	 * 카운트
	 * 
	 * @param int eventSeq
	 * @return int
	 */
	int count(int eventSeq);
}
