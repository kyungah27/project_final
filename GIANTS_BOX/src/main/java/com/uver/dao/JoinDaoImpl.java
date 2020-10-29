package com.uver.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uver.vo.JoinVO;
import com.uver99.example.UserDaoImpl;

@Repository("joinDaoImpl")
public class JoinDaoImpl {
	private static final Logger LOG = LoggerFactory.getLogger(JoinDaoImpl.class);

	@Autowired
	private JdbcTemplate jbcTemplate;

	public JoinDaoImpl() {
		super();
	}

	public int doInsert(JoinVO vo) {

		int flag = 0;

		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO event_join ( \n");
		sb.append(" 	    event_seq,       \n");
		sb.append(" 	    member_seq,      \n");
		sb.append(" 	    priority   		\n");
		sb.append(" ) VALUES (               \n");
		sb.append("     ?,                   \n");
		sb.append("     ?,                	 \n");
		sb.append("     ?                 	 \n");
		sb.append(" )                        \n");
		LOG.debug("=param=\n" + vo);

		LOG.debug("========================");

		Object[] args = { vo.getMember_seq(), vo.getEvent_seq(), vo.getPriority() };
		flag = this.jbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag=" + flag);

		return flag;
	}
	
	

}
