package com.uver.service;

import java.util.List;

import com.uver.vo.JoinVO;

public interface JoinService {
	
	
	//--------------bypass---------------------- 
	public int doInsert(JoinVO vo);
	public int doDelete(JoinVO vo);
	public JoinVO doSelectOne(JoinVO vo);
	public List doSelectList(JoinVO vo);
	public int doUpdate(JoinVO vo);	
	//--------------bypass---------------------- 
	
}
