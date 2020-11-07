package com.uver.service;

import java.util.List;

import com.uver.cmn.Search;
import com.uver.vo.EventImgVO;
import com.uver.vo.ImgVO;
	
public interface EventImgService {
	
	/**
	 * 이미지, 이벤트_이미지 테이블 등록
	 * 
	 * @param EventImgVO
	 * @return int (1: 성공 / 0: 실패)
	 */
	public int doInsert(EventImgVO eventImg);
	
	
	/**
	 * 이미지, 이벤트_이미지 테이블 등록 후 등록한 객체 얻기
	 * 
	 * @param eventImg
	 * @return eventImg
	 */
	public EventImgVO addAndGet(EventImgVO eventImg);
	
	
	/**
	 * 이미지, 이벤트_이미지 테이블 삭제
	 * 
	 * @param ing imgSeq
	 * @return int(1: 성공 / 0: 실패)
	 */
	public int doDelete(int imgSeq);
	
	/**
	 * 이미지 썸네일 여부 변경
	 * (y->n, n->y)
	 * 
	 * @param imgSeq
	 * @return int(1:성공 / 0: 실패)
	 */
	public int doUpdate(int imgSeq);
	
	/**
	 * 이미지seq 기반 단건 조회
	 * 
	 * @param int imgSeq
	 * @return EventImgVO
	 */
	public EventImgVO doSelectOne(int imgSeq);
	
	
	/**
	 * eventSeq로 검색하는 다건 조회
	 * 
	 * @param Search search
	 * @return List<EventImgVO> 
	 */
	public List<EventImgVO> doSelectList(Search search);
	
	
	/**
	 * regId로 검색하는 다건 조회
	 * 
	 * @param Search search
	 * @return List<ImgVO> 
	 */
	public List<ImgVO> doSelectListById(Search search);
	
	
	/**
	 * eventSeq 검색 후 가장 최근 등록된 객체 imgSeq 구하기
	 * 
	 * @param eventSeq
	 * @return imgSeq
	 */
	public int getMaxImgSeq(int eventSeq);
	
	

}
