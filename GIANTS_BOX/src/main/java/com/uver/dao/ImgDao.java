package com.uver.dao;

import java.util.List;

import com.uver.vo.ImgVO;

public interface ImgDao {

	/**
	 * 이미지 등록
	 * 
	 * @param ImgVO
	 */
	public int doInsert(ImgVO imgVO);
	
	/**
	 * 이미지 삭제
	 * 
	 * @param ImgVO
	 * @return 1(성공)/0(실패)
	 */
	public int doDelete(ImgVO imgVO);
	
	/**
	 * 이미지 수정
	 * 
	 * @param imgVO
	 * @return 1(성공)/0(실패)
	 */
	public int doUpdate(ImgVO imgVO);
	
	/**
	 * 이미지 단건조회
	 * 
	 * @param id
	 * @return ImgVO
	 */
	public ImgVO doSelectOne(int imgSeq);

	
	/**
	 * 이미지 다건조회
	 * 
	 * @param ImgVO
	 * @return List<ImgVO>
	 */
	public List<ImgVO> doSelectList(ImgVO imgVO);

	/**
	 * 카운트
	 * 
	 * @param cnt
	 * @return int
	 */
	public int count(ImgVO imgVO);
	
	
}
