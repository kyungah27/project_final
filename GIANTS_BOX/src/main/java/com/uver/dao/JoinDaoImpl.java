package com.uver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uver.vo.JoinMemberVO;
import com.uver.vo.JoinVO;

@Repository("joinDaoImpl")
public class JoinDaoImpl implements JoinDao {
	private static final Logger LOG = LoggerFactory.getLogger(JoinDaoImpl.class);
	final String NAME_SPACE ="com.uver.join";
	
	@Autowired
	private JdbcTemplate jbcTemplate;

	 @Autowired
	 SqlSessionTemplate sqlSessionTemplate;
	
	public JoinDaoImpl() {
		super();
	}
    RowMapper rowMapper= new RowMapper<JoinVO>() {
		@Override
		public JoinVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			JoinVO vo = new JoinVO();
			
			vo.setEventSeq(rs.getInt("event_seq"));
			vo.setMemberSeq(rs.getInt("member_seq"));
			vo.setPriority(rs.getInt("priority"));
			vo.setRegDt(rs.getString("reg_dt"));
			
			return vo;
		}

   };
   
   /**
    * 회원 가장 많이 참여하는 이벤트 리스트 순 추출
    * 
    * @return List<JoinVO>
    */
   public List doSelectTopEvents() {
	   LOG.debug("========================");
		String statement = this.NAME_SPACE +".doSelectTopEvents";
		
		LOG.debug("=statement="+statement);
		LOG.debug("========================");			
		
		List<JoinVO> list =this.sqlSessionTemplate.selectList(statement);
		
		for(JoinVO resultVO: list) {
			LOG.debug("=vo="+resultVO);
		}
		
		return list;
   }
	
   
	@Override
	public int doInsert(JoinVO vo) {

		LOG.debug("========================");
		LOG.debug("=doInsert=");
		LOG.debug("========================");
		String statement = NAME_SPACE+".doInsert";
		LOG.debug("=statement=\n"+statement);
	    LOG.debug("=param=\n"+vo);
	    int flag = sqlSessionTemplate.insert(statement,vo);
		LOG.debug("=flag="+flag);

		return flag;
	}

	@Override
	public int doDelete(JoinVO vo) {

		LOG.debug("========================");
		LOG.debug("=doDelete=");
		LOG.debug("========================");
		String statement = NAME_SPACE+".doDelete";
		LOG.debug("=statement=\n"+statement);
	    LOG.debug("=param=\n"+vo);
	    int flag = sqlSessionTemplate.delete(statement,vo);
		LOG.debug("=flag="+flag);

		return flag;
	}

	@Override
	public int doUpdate(JoinVO vo) {


		LOG.debug("========================");
		LOG.debug("=doUpdate=");
		LOG.debug("========================");
		String statement = NAME_SPACE+".doUpdate";
		LOG.debug("=statement=\n"+statement);
	    LOG.debug("=param=\n"+vo);
	    int flag = sqlSessionTemplate.update(statement,vo);
		LOG.debug("=flag="+flag);
		return flag;
	}
	
	@Override
	public JoinVO doSelectOne(JoinVO vo) {
		
		LOG.debug("========================");
		LOG.debug("=doSelectOne=");
		LOG.debug("========================");
		String statement = this.NAME_SPACE+".doSelectOne";
		LOG.debug("=statement="+statement);    	
		JoinVO outVO= this.sqlSessionTemplate.selectOne(statement, vo);
				
		LOG.debug("========================");
		LOG.debug("=outVO="+outVO);
		LOG.debug("========================");			
    	

    	return outVO;	
	}
	
	@Override
	public List doSelectList(JoinVO vo) {
		
	    LOG.debug("========================");
		String statement = this.NAME_SPACE +".doSelectList";
		
		LOG.debug("=statement="+statement);
		LOG.debug("=param="+vo);
		LOG.debug("========================");			
		
		List<JoinVO> list =this.sqlSessionTemplate.selectList(statement, vo);
		
		for(JoinVO resultVO: list) {
			LOG.debug("=vo="+vo);
		}
		
		
		
		return list;
	}
	
	@Override
	public int doSelectMinReg(int event_seq) {
		
	    LOG.debug("========================");
		String statement = this.NAME_SPACE +".doSelectMinReg";
		
		LOG.debug("=statement="+statement);
		LOG.debug("=param="+event_seq);
		LOG.debug("========================");			
		
		List<Integer> list =this.sqlSessionTemplate.selectList(statement, event_seq);
		for(int i : list) {
			LOG.debug("doSelectMinReg" + i);
		}
    	
    	return list.get(0);	
	}
	


	@Override
	public List<JoinMemberVO> currentJoinList(JoinVO vo) {
		// TODO Auto-generated method stub
	    LOG.debug("========================");
		String statement = this.NAME_SPACE +".currentJoinList";
		
		LOG.debug("=statement="+statement);
		LOG.debug("=param="+vo);
		LOG.debug("========================");			
		
		List<JoinMemberVO> list =this.sqlSessionTemplate.selectList(statement, vo);
		
		for(JoinMemberVO resultVO: list) {
			LOG.debug("=resultVO="+resultVO);
		}

		return list;	
	}

	@Override
	public int checkJoin(JoinVO vo) {
		// TODO Auto-generated method stub
	    LOG.debug("========================");
		String statement = this.NAME_SPACE +".doJoinCount";
		
		LOG.debug("=statement="+statement);
		LOG.debug("=param="+vo);
		LOG.debug("========================");			
		
		int count =this.sqlSessionTemplate.selectOne(statement, vo);
    	
    	return count;	
	}
	
	


}
