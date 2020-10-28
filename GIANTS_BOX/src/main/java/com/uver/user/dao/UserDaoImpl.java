package com.uver.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);
    
    private final JdbcTemplate jdbcTemplate;
    
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
    }
      
    RowMapper rowMapper= new RowMapper<User>() {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User outVO = new User();
			
			outVO.setU_id(rs.getString("u_id"));
			outVO.setName(rs.getString("name"));
			outVO.setPasswd(rs.getString("passwd"));
			
			outVO.setLevel(Level.valueOf(rs.getInt("u_level")) );
			outVO.setLogin(rs.getInt("login"));
			outVO.setRecommend(rs.getInt("recommend"));
			outVO.setMail(rs.getString("mail"));
			outVO.setRegDt(rs.getString("reg_dt"));
			return outVO;
		}

   };
    
   /**
	 * 사용자 등록
	 * @param user
	 */
   @Override
	public int doInsert(User user) {
	    int flag = 0;	    
	    Object[]  args = { user.getU_id(),
	    		           user.getName(),
	    		           user.getPasswd(),
	    		           user.getLevel().intValue(),
	    		           user.getLogin(),
	    		           user.getRecommend(),
	    		           user.getMail()
	    };
	    
		StringBuilder  sb=new StringBuilder();
		sb.append(" INSERT INTO hr_member ( \n");
		sb.append(" 	    u_id,           \n");
		sb.append(" 	    name,           \n");
		sb.append(" 	    passwd,         \n");
		//사용자 Level관리 기능 추가 : 2020/1020
		sb.append("         u_level,        \n");
		sb.append("         login,          \n");
		sb.append("         recommend,      \n");
		sb.append("         mail,           \n");
		sb.append("         reg_dt          \n");
		sb.append(" ) VALUES (              \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     sysdate             \n");
		sb.append(" )                       \n");
		LOG.debug("========================");
		//LOG.debug("=sql=\n"+sb.toString());
		LOG.debug("=param=\n"+user);

		LOG.debug("========================");			
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag="+flag);

		return flag;
	}
   
	
	/**
	 * 삭제
	 * @param user
	 * @return 1(성공)/0(실패)
	 */
   @Override
	public int doDelete(User user) {
		int flag = 0;
		
		StringBuilder  sb=new StringBuilder();
		sb.append(" DELETE FROM hr_member \n");
		sb.append(" WHERE u_id = ?        \n");
		
		LOG.debug("=====================================");
		LOG.debug("=sql=\n"+sb.toString());
		LOG.debug("=param="+user);
		LOG.debug("=====================================");
		Object[] args = {user.getU_id()};
		flag = this.jdbcTemplate.update(sb.toString(), args);
				
		return flag;
	}

   
   @Override
	public int doUpdate(User user) {
		int flag = 0;

		StringBuilder sb=new StringBuilder();
		sb.append(" UPDATE hr_member     \n");
		sb.append(" SET name   = ?,      \n");
		sb.append("     passwd = ?,      \n");
		sb.append("     u_level= ?,      \n");
		sb.append("     login= ?,        \n");
		sb.append("     recommend= ?,    \n");
		sb.append("     mail= ?,         \n");
		sb.append("     reg_dt= sysdate  \n");
		sb.append(" WHERE u_id = ?       \n");
	    LOG.debug("========================");
		//LOG.debug("=sql\n="+sb.toString());
		LOG.debug("=param="+user);
		LOG.debug("========================");	
		
		Object[] args = {user.getName(), 
				        user.getPasswd(),
				        user.getLevel().intValue(),
				        user.getLogin(),
				        user.getRecommend(),
				        user.getMail(),
				        user.getU_id()};
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag="+flag);		
		return flag;		
	}
	
	
	/**
	 * 단건 조회
	 * @param id
	 * @return User
	 */
   @Override
	public User doSelectOne(String id) {
    	User outVO = null; 	
		StringBuilder  sb=new StringBuilder();
		sb.append("  SELECT u_id,           \n");
		sb.append("         name,           \n");
		sb.append("         passwd,         \n");
		//사용자 Level관리 기능 추가 : 2020/1020
		sb.append("         u_level,        \n");
		sb.append("         login,          \n");
		sb.append("         recommend,      \n");
		sb.append("         mail,           \n");
		sb.append("         TO_CHAR(reg_dt,'YYYY-MM-DD HH24MISS') AS reg_dt \n");
		sb.append("  FROM  hr_member        \n");
		sb.append("  WHERE u_id = ?         \n");
		LOG.debug("========================");
		LOG.debug("=sql\n="+sb.toString());
		LOG.debug("=param="+id);
		LOG.debug("========================");		
    	
		Object args[] = {id};
		outVO = (User) this.jdbcTemplate.queryForObject(sb.toString(), 
    			                        args, 
    			                        rowMapper);
		
		LOG.debug("========================");
		LOG.debug("=outVO="+outVO);
		LOG.debug("========================");			
    	

    	return outVO;
    }
	
   /**
    * 다건 조회
    * @param user
    * @return List<User>
    */
   @Override
	public List<User> doSelectList(User user){
	    List<User> list = null;
	    StringBuilder sb=new StringBuilder();
	    sb.append(" SELECT  u_id,           \n");
	    sb.append("         name,           \n");
	    sb.append("         passwd,         \n");
		//사용자 Level관리 기능 추가 : 2020/1020
		sb.append("         u_level,        \n");
		sb.append("         login,          \n");
		sb.append("         recommend,      \n");
		sb.append("         mail,           \n");
		sb.append("         TO_CHAR(reg_dt,'YYYY-MM-DD HH24MISS') AS reg_dt \n");
	    sb.append(" FROM  hr_member     \n");
	    sb.append(" WHERE u_id like ?   \n");
	    sb.append(" ORDER BY u_id       \n");
	    LOG.debug("========================");
		//LOG.debug("=sql\n="+sb.toString());
		LOG.debug("=param="+user);
		LOG.debug("========================");	
		
		list = this.jdbcTemplate.query(sb.toString(), 
				               new Object[] {"%"+user.getU_id()+"%"}, 
				               rowMapper);
		for(User vo:list) {
			LOG.debug("====================================");
			LOG.debug("=vo="+vo);
			LOG.debug("====================================");
		}
	    
	    return list;
	}
	
	
	/**
	 * 카운트
	 * @param user
	 * @return int
	 */
   @Override
	public int count(User user){
		int  cnt = 0;
		
		StringBuilder  sb=new StringBuilder();
		sb.append(" SELECT COUNT(*) cnt \n");
		sb.append(" FROM hr_member      \n");
		sb.append(" WHERE u_id like ?   \n");
		LOG.debug("========================");
		LOG.debug("=sql\n="+sb.toString());
		LOG.debug("=param="+user);
		LOG.debug("========================");		
		
		cnt = this.jdbcTemplate.queryForObject(sb.toString(), 
				                        new Object[] {"%"+user.getU_id()+"%"}
		                               , Integer.class);

		LOG.debug("========================");
		LOG.debug("=cnt="+cnt);
		LOG.debug("========================");			

    	return cnt;
	}



}