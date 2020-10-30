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

	/**
	 * priority가 1 인경우 가장 빨리 참여한 id에 priority를 1증가 시킨 후 삭제
	 */
	@Override
	public int doDelete(JoinVO vo) {
		// TODO Auto-generated method stub
		int flag = 0;
		if (vo.getPriority() == 1) {
			int deleteFlag = joinDao.doDelete(vo);
			if (deleteFlag == 1) {
				int minRegId = joinDao.doSelectMinReg(vo.getEventSeq());
				joinDao.doUpdate(new JoinVO(vo.getEventSeq(), minRegId, 1));
			} else {
				throw new RuntimeException("doDelete 실패");
			}
		} else {
			return joinDao.doDelete(vo);
		}
		return flag;
	}

	// ----------------bypass----------------------
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
