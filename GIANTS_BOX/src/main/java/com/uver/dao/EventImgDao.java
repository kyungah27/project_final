package com.uver.dao;

import java.util.List;

import com.uver.vo.EventImgVO;

public interface EventImgDao {
	
	/**
	 * 이미지 등록
	 * 
	 * @param EventImgVO
	 */
	public int doInsert(EventImgVO eventImgVO);
	
	/**
	 * 다건 조회
	 * 
	 * @param int eventSeq
	 * @return List<EventImgVO>
	 */
	public List<EventImgVO> doSelectList(int eventSeq);

	/**
	 * 카운트
	 * 
	 * @param int eventSeq
	 * @return int
	 */
	public int count(int eventSeq);

}
