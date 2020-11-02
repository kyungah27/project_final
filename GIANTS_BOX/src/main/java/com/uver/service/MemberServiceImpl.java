package com.uver.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uver.dao.MemberDao;
import com.uver.dao.MemberDaoImpl;
import com.uver.vo.MemberVO;

@Service("MemberServiceImpl")
public class MemberServiceImpl {
	final Logger LOG = LoggerFactory.getLogger(MemberServiceImpl.class);
@Autowired
MemberDaoImpl memberDaoImpl;

public MemberServiceImpl() {}


public void setMemberDaoImpl(MemberDaoImpl memberDaoImpl) {
	this.memberDaoImpl = memberDaoImpl;
}



/**
 * 로그인
 * 
 * @param user
 */
// View User loginUser 를줌  -> Controller ( Service.login(loginUser) )  -> Service(userDaoImpl.doSelectList(); ) 

MemberVO inputUser = new MemberVO();

public MemberVO login(MemberVO inputUser) {
	MemberVO resultVO = null;
	MemberVO searchMember = new MemberVO();
	searchMember.setUserId("H");

	List<MemberVO> list = memberDaoImpl.doSelectList("10", "H"); // H170_01

	for (MemberVO vo : list) {
		if (vo.getUserId().equals(inputUser.getUserId()) && vo.getPassword().equals(inputUser.getPassword())) {
			LOG.debug("로그인에 성공하셨습니다.");
			resultVO = vo;
		}
	}
	if (resultVO == null) {
		LOG.debug("아이디 혹은 비밀번호를 확앤해주세요");
	}

	return resultVO;
}


}
