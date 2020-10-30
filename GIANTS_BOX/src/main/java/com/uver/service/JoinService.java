package com.uver.service;

import java.util.List;

import com.uver.vo.JoinVO;

public interface JoinService {
	
	
	//--------------bypass---------------------- 
	public int doInsert(JoinVO vo);
	
	public JoinVO doSelectOne(JoinVO vo);
	public List doSelectList(JoinVO vo);
	public int doUpdate(JoinVO vo);	
	//--------------bypass---------------------- 
	
	/**
	 * 만약 prioriy가 1이면 등록일이 가장 빠른사람에게 priority를 1 부여
	 * @param vo
	 * @return flag 1 성공 0 실패
	 */
	public int doDelete(JoinVO vo);
}
