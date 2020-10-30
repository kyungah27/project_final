package com.uver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uver.dao.JoinDao;
import com.uver.dao.JoinDaoImpl;
import com.uver.vo.JoinVO;

@Service("JoinServiceImpl")
public class JoinServiceImpl implements JoinService {

	
	@Autowired
	JoinDao joinDao;
	
	@Override
	public int doDelete(JoinVO vo) {
		// TODO Auto-generated method stub
		if(vo.getPriority() == 1) {
			List<JoinVO> list  = joinDao.doSelectList(vo);  //쿼리하나 짜야하나 싶음 일단.
			for(int i=0; i<list.size(); i++) {			
			}
		}
		
		
		
		
		return joinDao.doDelete(vo);
	}
	
	
	
	
	
	
	
	
	//----------------bypass---------------------- 
	@Override
	public int doInsert(JoinVO vo) {
		// TODO Auto-generated method stub
		return joinDao.doInsert(vo);
	}



	@Override
	public int doUpdate(JoinVO vo) {
		// TODO Auto-generated method stub
		return joinDao.doUpdate(vo);
	}

	@Override
	public JoinVO doSelectOne(JoinVO vo) {
		// TODO Auto-generated method stub
		return joinDao.doSelectOne(vo);
	}

	@Override
	public List doSelectList(JoinVO vo) {
		// TODO Auto-generated method stub
		return joinDao.doSelectList(vo);
	}

}
