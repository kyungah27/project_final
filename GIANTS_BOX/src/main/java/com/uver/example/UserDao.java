package com.uver.example;

import java.util.List;

public interface UserDao {
	
	/**
	 * 사용자 등록
	 * @param user
	 */
	public int doInsert(User user);
	
	/**
	 * 삭제
	 * @param user
	 * @return 1(성공)/0(실패)
	 */
	public int doDelete(User user);
	
	/**
	 * 수정
	 * @param user
	 * @return 1(성공)/0(실패)
	 */
	public int doUpdate(User user);
	
	/**
	 * 단건조회
	 * @param id
	 * @return User
	 */
	public User doSelectOne(String id);

	/**
	 * 다건조회
	 * @param user
	 * @return List<User>
	 */
	public List<User> doSelectList(User user);

	public int count(User user);
	
}