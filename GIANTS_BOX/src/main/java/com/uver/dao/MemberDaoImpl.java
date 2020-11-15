package com.uver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.uver.vo.ImgVO;
import com.uver.vo.MemberVO;

@Repository("MemberDaoImpl")
public class MemberDaoImpl implements MemberDao {
	final static Logger LOG = LoggerFactory.getLogger(MemberDaoImpl.class);
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private final String NAMESPACE = "com.uver.member";
	
	public MemberDaoImpl() {
	}
	
	@Override
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
			outVO.setSeq(rs.getInt("seq"));
			
			return outVO;
		}
   }; //---row mapper end
	
   
   @Override
public int doUpdata(MemberVO member) {
	   LOG.debug("=====================");
		LOG.debug("=doUpdate=");
		LOG.debug("=====================");
		//등록 : namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE +".doUpdate";
		LOG.debug("=statement="+statement);	
		
		int flag = sqlSessionTemplate.update(statement,member);
		LOG.debug("=flag="+flag);
		
		return flag;
   }
   
	
	
	@Override
	public MemberVO doSelectOne(int seq) {
		LOG.debug("=====================");
		LOG.debug("=doSelectOneById=");
		LOG.debug("=====================");	
		
		//단건조회 : namespace+id = com.sist.ehr.board.doSelectOne
		String statement = NAMESPACE +".doSelectOneById";	
		LOG.debug("=statement="+statement);
		LOG.debug("=seq="+seq);	
				
		MemberVO outVO = this.sqlSessionTemplate.selectOne(statement, seq);
		LOG.debug("=outVO="+outVO);
		
		return outVO;
	}
	
	@Override
	public MemberVO doSelectOneById(String id) {
		
		LOG.debug("=====================");
		LOG.debug("=doSelectOneById=");
		LOG.debug("=====================");	
		
		//단건조회 : namespace+id = com.sist.ehr.board.doSelectOne
		String statement = NAMESPACE +".doSelectOneById";	
		LOG.debug("=statement="+statement);
		LOG.debug("=id="+id);	
				
		MemberVO outVO = this.sqlSessionTemplate.selectOne(statement, id);
		LOG.debug("=outVO="+outVO);
		
		return outVO;
	}
	
	/**
	 * 리스트 조건 조회
	 * @param div
	 * @param searchWord
	 * @return
	 */
	@Override
	public List<MemberVO> doSelectList(String div , String searchWord) {
		

		
		StringBuilder sbWhere=new StringBuilder();
		//검색구분!= null !"".equals(검색구분)
		//아이디(10),이름(20)
		if(null != div && !"".equals(div)) {
			if("10".equals(div)) {
				sbWhere.append(" WHERE user_id like '%'|| ? ||'%'  \n");
			}else if("20".equals(div)) {
				sbWhere.append(" WHERE name like '%'|| ? ||'%'  \n");
			}
			
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append(" SELECT               \n");
	    sb.append(" seq,                 \n");
	    sb.append(" user_id,             \n");
	    sb.append(" name,                \n");
	    sb.append(" password,            \n");
	    sb.append(" email,               \n");
	    sb.append(" cell_phone,          \n");
	    sb.append(" birthday,            \n");
	    sb.append(" genre,               \n");
	    sb.append(" auth,                \n");
	    sb.append(" reg_dt               \n");
		sb.append(" FROM member          \n");
		sb.append(sbWhere.toString());
		LOG.debug("========================");
		LOG.debug("=sql\n="+sb.toString());
		LOG.debug("=param="+div+","+searchWord);
		LOG.debug("========================");	
		
		Object[] args  = { searchWord };	
		List<MemberVO> list = (List<MemberVO>)jdbcTemplate.query(sb.toString(), args, rowMapper);
		LOG.debug("list.size()" +list.size());
		for(MemberVO vo: list) {
			LOG.debug("=vo="+vo);
		}
		
		return list;
	}
	
	
	/**
	 * 리스트 조회
	 * @param div
	 * @param searchWord
	 * @return
	 */
	@Override
	public List<MemberVO> doSelectListAll() {
		LOG.debug("=====================");
		LOG.debug("=doSelectListAll=");
		LOG.debug("=====================");
		//등록 : namespace+id = com.sist.ehr.board.doSelectList
		String statement = NAMESPACE +".doSelectListAll";		
		LOG.debug("=statement="+statement);	
		List<MemberVO> list =this.sqlSessionTemplate.selectList(statement);
		
		for(MemberVO vo :list) {
			LOG.debug("=vo="+vo);
		}
		
		return list;
	}
	
	/**
	 * 삭제
	 * @param member
	 * @return
	 */
	@Override
	public int doDeleteOne(MemberVO inputUser) {
		LOG.debug("=====================");
		LOG.debug("=doDelete=");
		LOG.debug("=====================");
		String statement = NAMESPACE +".doDeleteOne";

		LOG.debug("==========================");
		LOG.debug("=statement="+statement);
		LOG.debug("=inputUser="+inputUser);	

		int flag = sqlSessionTemplate.delete(statement, inputUser);
		LOG.debug("=flag="+flag);
		
		return flag;
	}
	
	
	/**
	 * 사용자등록
	 * @param member
	 * @return
	 */
	@Override
	public int doInsert(MemberVO memberVO) {
		LOG.debug("=====================");
		LOG.debug("=doInsert=");
		LOG.debug("=====================");
		//등록
		String statement = NAMESPACE +".doInsert";
		LOG.debug("=statement="+statement);
		LOG.debug("=memberVO="+memberVO);
		int flag = sqlSessionTemplate.insert(statement,memberVO);
		LOG.debug("=flag="+flag);
		return flag;
	}
		

	@Override
	public int doDelete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
