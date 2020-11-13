package com.uver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uver.cmn.Search;
import com.uver.vo.ReviewVO;

	@Repository("reviewDaoImpl")
	public class ReviewDaoImpl {
	final static Logger LOG = LoggerFactory.getLogger(ReviewDaoImpl.class);
	/*
	@Autowired
	JdbcTemplate jdbcTemplate;
	*/
	
	//추가
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	//  <!-- dao mapper에 sql을 실행 class -->
	/*
	 * <bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate"
	 * destroy-method="clearCache"> <constructor-arg index="0"
	 * ref="sqlSessionFactoryBean"/> </bean>
	 */
	//추가
	private final String NAMESPACE = "com.uver.review";
	
	public ReviewDaoImpl() {
	}
	
	/*
	@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
	*/
	
	//rowMapper
	RowMapper<ReviewVO> rowMapper= new RowMapper<ReviewVO>() {
	@Override
	public ReviewVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReviewVO outVO = new ReviewVO(
						rs.getInt("review_seq"),
						rs.getInt("event_seq"),
						rs.getString("writer"),
						rs.getString("title"),		
						rs.getString("context"),
						rs.getString("reg_dt"),
						rs.getInt("div"),										
						rs.getString("mod_dt")
						);
			outVO.setReview_seq(rs.getInt("review_seq"));
			
			return outVO;
		}
   }; //---row mapper end
   
   


   
   //CREATE
   public int doInsert(ReviewVO review){
		LOG.debug("=====================");
		LOG.debug("=doInsert=");
		LOG.debug("=====================");
		//등록 : namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE +".doInsert";
		LOG.debug("=statement="+statement);
		LOG.debug("=review="+review);
		int flag = sqlSessionTemplate.insert(statement, review);
		LOG.debug("=flag="+flag);
		return flag;
	}
   /*
   @Override
	public int doInsert(ReviewVO review) {
		int flag = 0;
		
		Object[] args = {
				//review.getReview_seq(), 
				review.getEventSeq(),
				review.getWriter(),				
				review.getTitle(),
				review.getContext(),				
				//review.getReg_dt(),
				review.getDiv(),
				//review.getMod_dt()
				
		};
		
		StringBuilder sb = new StringBuilder();
		   
		sb.append(" INSERT INTO review ( \n");
		sb.append("     review_seq,             \n");
		sb.append("     event_seq,             \n");
		sb.append("     writer,         \n");
		sb.append("     title,            \n");
		sb.append("     context,        \n");
		sb.append("     reg_dt,           \n");
		sb.append("     div,      \n");
		sb.append("     mod_dt        \n");		
		sb.append(" ) VALUES (           \n");
		sb.append("  review_seq.NEXTVAL, \n");
		sb.append("     ?,               \n");//evt
		sb.append("     ?,               \n");//writer
		sb.append("     ?,               \n");//title
		sb.append("     ?,               \n");//context
		sb.append("     sysdate,               \n");
		sb.append("     ?,               \n");//div
		sb.append("     sysdate               \n");		
		sb.append(" )                    \n");
		
		LOG.debug("==========================");
		LOG.debug("=sql=\n"+sb.toString());
		LOG.debug("=param=\n"+review);
		LOG.debug("==========================");
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag="+flag);
		
		return flag;
	}
	*/
   
   //delete
   public int doDelete(ReviewVO review){
		LOG.debug("=====================");
		LOG.debug("=doDelete=");
		LOG.debug("=====================");
		//등록 : namespace+id = com.sist.ehr.review.doInsert
		String statement = NAMESPACE +".doDelete";
		LOG.debug("=statement="+statement);
		LOG.debug("=review="+review);		
		
		int flag = sqlSessionTemplate.delete(statement, review);
		LOG.debug("=flag="+flag);
		
		return flag;
	}
   /*
   @Override
	public int doDelete(ReviewVO review) {
		int flag = 0;

		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM review \n");
		sb.append(" WHERE review_seq = ?      \n");

		LOG.debug("==========================");
		LOG.debug("=sql=\n" + sb.toString());
		LOG.debug("=param=\n" + review);
		LOG.debug("==========================");

		//Object[] args = { review };
		Object[] args = { review.getReview_seq() };
		LOG.debug("args:"+args);		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag:"+flag);
		
		return flag;
	}
   */
   
   //update
   public int doUpdate(ReviewVO vo) {
		LOG.debug("=====================");
		LOG.debug("=doUpdate=");
		LOG.debug("=====================");
		//등록 : namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE +".doUpdate";
		LOG.debug("=statement="+statement);	
		
		int flag = sqlSessionTemplate.update(statement,vo);
		LOG.debug("=flag="+flag);
		
		return flag;
	}
   /*
   @Override
   public int doUpdate(ReviewVO vo) {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		//Object[] args = { vo.getEventSeq(), vo.getWriter(), vo.getTitle(), vo.getContext(), vo.getDiv()};
		
		sb.append("UPDATE  review	 \n");
		sb.append("SET                   \n");
		sb.append("    event_seq = ?,      \n");
		sb.append("    writer = ?,      \n");
		sb.append("    title = ?,      \n");		
		sb.append("    context = ?,      \n");
		sb.append("     div = ?,      \n");
		sb.append("    mod_dt = SYSDATE  \n");
		sb.append("WHERE                 \n");
		sb.append("    review_seq = ?   \n");		
		LOG.debug("=sql=\n"+sb.toString());
		LOG.debug("=param=" + vo);
		LOG.debug("========================");

		Object[] args = {vo.getEventSeq(), vo.getWriter(), vo.getTitle(), vo.getContext(), vo.getDiv(), vo.getReview_seq() };
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag=" + flag);
		return flag;
	}
   */
	
   
   
	/* 안씀
	@Override
	public int ReviewVO doSelectOneByTitle(String title) {
		int flag = 0;
		ReviewVO outVO = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT          \n");
	    sb.append(" review_seq,            \n");
	    sb.append(" div,        \n");
	    sb.append(" title,           \n");
	    sb.append(" context,       \n");
	    sb.append(" writer,          \n");
	    sb.append(" reg_dt,     \n");
	    sb.append(" mod_dt,       \n");	   
		sb.append(" FROM review     \n");
		sb.append(" WHERE title = ?   \n");
		
		LOG.debug("-----------------------------");
		//LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + title);
		LOG.debug("-----------------------------");	
		
		Object args[] = {title};
		outVO = (ReviewVO)this.jdbcTemplate.queryForObject(sb.toString(), 
															args, 
															rowMapper);
		
		LOG.debug("==========================");
		LOG.debug("=outVO="+outVO);
		LOG.debug("==========================");

		//return outVO;
		return flag;
	}
	*/
   
   //selectOne
   public ReviewVO  doSelectOne(ReviewVO reviewVO){
		LOG.debug("=====================");
		LOG.debug("=doSelectOne=");
		LOG.debug("=====================");	
		//단건조회 : namespace+id = com.sist.ehr.board.doSelectOne
		String statement = NAMESPACE +".doSelectOne";	
		LOG.debug("=statement="+statement);
		LOG.debug("=reviewVO="+reviewVO);	
		
		ReviewVO outVO = this.sqlSessionTemplate.selectOne(statement, reviewVO);
		LOG.debug("=outVO="+outVO);
		
		return outVO;
	}
   /*원래내가썼던거
	@Override
	public ReviewVO doSelectOne(int review_seq) {
		ReviewVO outVO = null;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT			   \n");
		sb.append("    review_seq,    \n");		
		sb.append("    event_seq,    \n");	
		sb.append("    writer,            \n");
		sb.append("    title,            \n");
		sb.append("    context,        \n");		
		sb.append("    TO_CHAR(reg_dt, 'YY/MM/DD HH24:MI:SS') AS reg_dt,         \n");		
		sb.append("    div,            \n");
		sb.append("    TO_CHAR(mod_dt, 'YY/MM/DD HH24:MI:SS') AS mod_dt          \n");
		sb.append("FROM                \n");
		sb.append("    review      \n");
		sb.append("WHERE review_seq=? \n");

		Object[] args = { review_seq };
		outVO = (ReviewVO) this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);

		LOG.debug("=====================================");
		LOG.debug("=outVO=" + outVO);
		LOG.debug("=====================================");

		return outVO;

	}
	*/
   
   
	
	//div 조회? selectlist
   public List<ReviewVO> doSelectList(Search search){
		LOG.debug("=====================");
		LOG.debug("=doSelectList=");
		LOG.debug("=====================");
		
		String statement = NAMESPACE + ".doSelectList";
		LOG.debug("=statement="+statement);
		LOG.debug("=param="+search);
		
		List<ReviewVO> list = this.sqlSessionTemplate.selectList(statement, search);
		for(ReviewVO vo :list) {
			LOG.debug("=vo="+vo);
		}
		
		return list;
	}
   
   /* 원래 썼던것
	@Override
	public List<ReviewVO> doSelectList(ReviewVO vo) {
		List<ReviewVO> list = null;
		Object[] args = { vo.getEventSeq(), vo.getDiv() };
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT												\n");
		sb.append("    review_seq,                                     \n");
		sb.append("    event_seq,                                     \n");
		sb.append("    writer,                                             \n");
		sb.append("    title,                                         \n");
		sb.append("    context,                                             \n");
		sb.append("    TO_CHAR(reg_dt, 'YY/MM/DD HH24:MI:SS') AS reg_dt,  \n");	
		sb.append("    div,                                             \n");
		sb.append("    TO_CHAR(mod_dt, 'YY/MM/DD HH24:MI:SS') AS mod_dt   \n");
		sb.append("FROM                                                 \n");
		sb.append("    review                                       \n");
		sb.append("WHERE event_seq=?                                          \n");
		sb.append("AND div=?                                            \n");
		sb.append("ORDER BY mod_dt desc                                \n");

		list = (List<ReviewVO>) this.jdbcTemplate.query(sb.toString(), args, rowMapper);

		for (ReviewVO review : list) {
			LOG.debug("[review] " + review);
		}

		return list;
	}
	*/
	
	/*
	@Override
	public List<ReviewVO> doSelectList(String div , String searchWord) {		
		
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
		sb.append(" SELECT          \n");
	    sb.append(" review_seq,            \n");
	    sb.append(" div,        \n");
	    sb.append(" title,           \n");
	    sb.append(" context,       \n");
	    sb.append(" writer,          \n");
	    sb.append(" reg_dt,     \n");
	    sb.append(" mod_dt,       \n");	   
		sb.append(" FROM review     \n");
		sb.append(sbWhere.toString());
		LOG.debug("========================");
		LOG.debug("=sql\n="+sb.toString());
		LOG.debug("=param="+div+","+searchWord);
		LOG.debug("========================");	
		
		Object[] args  = { searchWord };	
		List<ReviewVO> list = (List<ReviewVO>)jdbcTemplate.query(sb.toString(), args, rowMapper);
		LOG.debug("list.size()" +list.size());
		for(ReviewVO vo: list) {
			LOG.debug("=vo="+vo);
		}
		
		return list;
	}
	*/
	
	
	
	

	
	
	
}
