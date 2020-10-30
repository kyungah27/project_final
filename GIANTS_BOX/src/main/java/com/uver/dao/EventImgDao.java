package com.uver.dao;

import java.util.List;

import com.uver.vo.EventImgVO;

public interface EventImgDao extends ImgJoinDao<EventImgVO> {
	/**
	 * 이미지 등록
	 * 
	 * @param EventImgVO
	 */
	@Override
	int doInsert(EventImgVO eventImgVO);

	/**
	 * 다건 조회
	 * 
	 * @param int eventSeq
	 * @return List<EventImgVO>
	 */
	@Override
	List<EventImgVO> doSelectList(int eventSeq);


}
