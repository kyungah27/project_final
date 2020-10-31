package com.uver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.uver.vo.ImgVO;
import com.uver.vo.MemberVO;

public class MemberDao {
	final static Logger LOG = LoggerFactory.getLogger(MemberDao.class);
	
	JdbcTemplate jdbcTemplate;
	
	public MemberDao() {
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/** row mapper */
	RowMapper<MemberVO> rowMapper= new RowMapper<MemberVO>() {
		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO outVO = new MemberVO(
						rs.getString("user_id"),
						rs.getString("name"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getString("cell_phone"),
						rs.getString("birthday"),
						rs.getInt("auth"),
						rs.getString("genre")
						);
			
			return outVO;
		}
   }; //---row mapper end
	
   
   public int doUpdata(MemberVO member) {
	   int flag = 0;
	   
	   
	   
	   
	   return flag;
   }
   
	
	
	public MemberVO doSelectOne(String id) {
		MemberVO outVO = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT          \n");
	    sb.append(" seq,            \n");
	    sb.append(" user_id,        \n");
	    sb.append(" name,           \n");
	    sb.append(" password,       \n");
	    sb.append(" email,          \n");
	    sb.append(" cell_phone,     \n");
	    sb.append(" birthday,       \n");
	    sb.append(" genre,          \n");
	    sb.append(" auth,           \n");
	    sb.append(" reg_dt          \n");
		sb.append(" FROM member     \n");
		sb.append(" WHERE user_id = ?   \n");
		
		LOG.debug("-----------------------------");
		//LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + id);
		LOG.debug("-----------------------------");	
		
		Object args[] = {id};
		outVO = (MemberVO)this.jdbcTemplate.queryForObject(sb.toString(), 
															args, 
															rowMapper);
		
		LOG.debug("==========================");
		LOG.debug("=outVO="+outVO);
		LOG.debug("==========================");

		return outVO;
	}
	/**
	 * 삭제
	 * @param member
	 * @return
	 */
	public int doDelete(MemberVO member) {
		int flag = 0;

		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM member \n");
		sb.append(" WHERE seq = ?      \n");

		LOG.debug("==========================");
		LOG.debug("=sql=\n" + sb.toString());
		LOG.debug("=param=\n" + member);
		LOG.debug("==========================");

		Object[] args = { member };
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag"+flag);
		
		return flag;
	}
	
	
	/**
	 * 사용자등록
	 * @param member
	 * @return
	 */
	public int doInsert(MemberVO member) {
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
