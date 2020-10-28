package com.uver99.example;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
	
	public int doInsert(User user);
	
	public int doDelete(User user);
	
	public int doUpdate(User user);
	
	public User doSelectOne(String id);
	
	public List<User> doSelectList(User user);
	
	/**
	 * 최초등록시 등급을 basic처리
	 * 비지니스 로직
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	int add(User user) throws ClassNotFoundException, SQLException;

	/**
	 * 등업
	 * 1. 전체사용자를 읽어 들인다.
	 * 2. 등업 대상자 선별.
	 *  2.1. BASIC사용자 : 로그인 CNT 50이상이면 : SILVER
	 *  2.2. SILVER사용자 : 추천이 CNT 30이상이면 : GOLD
	 *  2.3. GOLD 대상 아님
	 * 3.등업 
	 * 
	 * **트랜잭션 동기화: txXXXXX
	 * @param user
	 */
	void upgradeLevels(User user) throws Exception;

}