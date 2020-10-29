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
	 * 이미지 삭제
	 * 
	 * @param EventImgVO
	 * @return 1(성공)/0(실패)
	 */
	public int doDelete(EventImgVO eventImgVO);

	
	/**
	 * 단건 조회
	 * 
	 * @param EventImgVO
	 * @return EventImgVO
	 */
	public EventImgVO doSelectOne(EventImgVO eventImgVO);

	
	/**
	 * 다건 조회
	 * 
	 * @param EventImgVO
	 * @return List<EventImgVO>
	 */
	public List<EventImgVO> doSelectList(EventImgVO eventImgVO);

	/**
	 * 카운트
	 * 
	 * @param cnt
	 * @return int
	 */
	public int count(EventImgVO eventImgVO);

}
