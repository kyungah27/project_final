package com.uver.service;

import java.util.List;
import com.uver.vo.ReviewVO;


	public interface ReviewService {
	
	public int doInsert(ReviewVO reviewVO);	
	public int doDelete(ReviewVO reviewVO);	
	public int doUpdate(ReviewVO reviewVO);	
	public ReviewVO doSelectOne(int review_seq);	
	//public ReviewVO doSelectOneById(String writer);
	public List<ReviewVO> doSelectList(ReviewVO reviewVO);
}
