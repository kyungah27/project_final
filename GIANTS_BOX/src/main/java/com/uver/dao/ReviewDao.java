package com.uver.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.uver.vo.CommentVO;
import com.uver.vo.ReviewVO;

public interface ReviewDao {

	void setJdbcTemplate(JdbcTemplate jdbcTemplate);		

		
	int doInsert(ReviewVO review);
	
	int doDelete(ReviewVO review);
	
	int doUpdate(ReviewVO review);
	
	ReviewVO doSelectOne(int review_seq);
	
	ReviewVO doSelectOneById(String writer);
	
	//List<ReviewVO> doSelectList(String div, String searchWord);
	
	List<ReviewVO> doSelectList(ReviewVO vo);

}