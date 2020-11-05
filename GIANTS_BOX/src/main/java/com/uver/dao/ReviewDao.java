package com.uver.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.uver.vo.ReviewVO;

public interface ReviewDao {

	void setJdbcTemplate(JdbcTemplate jdbcTemplate);

	int doUpdate(ReviewVO review);

	ReviewVO doSelectOne(int seq);

	ReviewVO doSelectOneById(String id);

	/**
	 * 
	 * @param div
	 * @param searchWord
	 * @return
	 */
	List<ReviewVO> doSelectList(String div, String searchWord);

	/**
	 * 삭제
	 * 
	 * @param member
	 * @return
	 */
	int doDelete(int seq);

	/**
	 * 사용자등록
	 * 
	 * @param member
	 * @return
	 */
	int doInsert(ReviewVO review);

}