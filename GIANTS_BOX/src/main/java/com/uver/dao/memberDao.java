package com.uver.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.uver.vo.memberVO;

public class memberDao {
	final static Logger LOG = LoggerFactory.getLogger(memberDao.class);
	
	JdbcTemplate jdbcTemplate;
	
	public memberDao() {
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 사용자등록
	 * @param member
	 * @return
	 */
	public int doInsert(memberVO member) {
		int flag = 0;
		
		Object[] args = {
						 member.getUserId(), 
						 member.getName(),
						 member.getPassword(),
						 member.getEmail(),
						 member.getCellPhone(),
						 member.getBirthday(),
						 member.getAuth(),
						 member.getGenre()
		};
		
		StringBuilder sb = new StringBuilder();
		   
		sb.append(" INSERT INTO member ( \n");
		sb.append("     seq,             \n");
		sb.append("     user_Id,         \n");
		sb.append("     name,            \n");
		sb.append("     password,        \n");
		sb.append("     email,           \n");
		sb.append("     cell_phone,      \n");
		sb.append("     birthday,        \n");
		sb.append("     auth,            \n");
		sb.append("     reg_dt,          \n");
		sb.append("     genre            \n");
		sb.append(" ) VALUES (           \n");
		sb.append("  seq_member.NEXTVAL, \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     sysdate,         \n");
		sb.append("     ?                \n");
		sb.append(" )                    \n");
		
		LOG.debug("==========================");
		LOG.debug("=sql=\n"+sb.toString());
		LOG.debug("=param=\n"+member);
		LOG.debug("==========================");
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag="+flag);
		
		return flag;
	}
	
	
	
}
