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
	
	/**
	 * 아이디 하나 조회
	 * @param inputUser
	 * @return
	 */
	public MemberVO selectOne(MemberVO inputUser);
	
	
	/**
	 * 아이디 중복 확인
	 * @param inputUser
	 * @return
	 */
	int idCheck(MemberVO inputUser);
	
	/**
	 * 회원정보 수정
	 * @param inputUser
	 * @return
	 */
	public int myUpdate(MemberVO inputUser);
	
	/**
	 * ID 삭제
	 * @param inputUser
	 * @return
	 */
	public int idDelete(MemberVO inputUser);

	MemberVO login(MemberVO inputUser);

	void logout(HttpSession session);

}