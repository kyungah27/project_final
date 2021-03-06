package com.uver.service;

import java.util.HashMap;

import com.uver.vo.LikeVO;

public interface LikeServcie {
	 /* 게시판의 좋아요 번호가 있는지 카운트 */
	  public int countLike(LikeVO likeVO);
	  
	  /* 좋아요 번호 등록 */
	  public int doInsert(LikeVO likeVO);
	  
	  /**
	   * 좋아요 체크 여부 (0 -> 1)
	   * @param hashMap
	   * @return
	   */
	  public int likeCheck(LikeVO likeVO);
	  
	  /**
	   * 좋아요 체크 여부 (1 -> 0)
	   * @param hashMap
	   * @return
	   */
	  public int likeCheckCancel(LikeVO likeVO);
	  
	  /* 조회 */
	  public LikeVO read(LikeVO likeVO);
	 
	  /* 게시판의 좋아요 삭제 */
	  public int deleteCommentSeq(int commentSeq);
	  
	  /* 회원의 좋아요 삭제 */
	  public int deleteMemberSeq(int memberSeq);
}
