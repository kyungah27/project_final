package com.uver.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.uver.dao.MemberDaoImpl;
import com.uver.vo.MemberVO;

public interface MemberService {

	void setMemberDaoImpl(MemberDaoImpl memberDaoImpl);

	/**
	 * 회원가입
	 * @param inputuser
	 * @return
	 */
	int regMember(MemberVO inputUser);

	/**
	 * 비밀번호조건
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	int regPw(MemberVO inputUser) throws ClassNotFoundException, SQLException;

	MemberVO login(MemberVO inputUser);

	void logout(HttpSession session);

}