package com.uver.user.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface UserDao {

	//setter를 통한 DI
	//N사,D사
	public void setDataSource(DataSource dataSource);

	public int doUpdate(User user);

	public List<User> doSelectList(User user);

	public int count(User user) throws ClassNotFoundException, SQLException;

	/**
	 * 삭제
	 * @param user
	 * @return 1(성공)/0(실패)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int doDelete(User user) throws ClassNotFoundException, SQLException;

	/**
	 * 사용자 등록
	 * @param user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int doInsert(User user) throws ClassNotFoundException, SQLException;

	/**
	 * 등록된 사용자 정보 조회
	 * @param id
	 * @return User
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User doSelectOne(String id) throws ClassNotFoundException, SQLException;

}