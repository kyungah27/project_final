package com.uver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uver.vo.CommentVO;
import com.uver.vo.ReviewVO;

	@Repository("ReviewDaoImpl")
	public class ReviewDaoImpl implements ReviewDao {
	final static Logger LOG = LoggerFactory.getLogger(ReviewDaoImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public ReviewDaoImpl() {
	}
	
	@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}	
	
	
	//rowMapper
	RowMapper<ReviewVO> rowMapper= new RowMapper<ReviewVO>() {
	@Override
	public ReviewVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReviewVO outVO = new ReviewVO(
						rs.getInt("review_seq"),
						rs.getInt("div"),
						rs.getString("context"),
						rs.getString("writer"),
						rs.getString("reg_dt"),
						rs.getString("title"),						
						rs.getString("mod_dt")
						);
			outVO.setReview_seq(rs.getInt("review_seq"));
			
			return outVO;
		}
   }; //---row mapper end
   
   
   
   //CREATE
   @Override
	public int doInsert(ReviewVO review) {
		int flag = 0;
		
		Object[] args = {
				review.getReview_seq(), 
				review.getDiv(),
				review.getTitle(),
				review.getContext(),
				review.getWriter(),
				review.getReg_dt(),
				review.getMod_dt()
				
		};
		
		StringBuilder sb = new StringBuilder();
		   
		sb.append(" INSERT INTO review ( \n");
		sb.append("     review_seq,             \n");
		sb.append("     div,         \n");
		sb.append("     title,            \n");
		sb.append("     context,        \n");
		sb.append("     writer,           \n");
		sb.append("     reg_dt,      \n");
		sb.append("     mod_dt,        \n");		
		sb.append(" ) VALUES (           \n");
		sb.append("  review_seq.NEXTVAL, \n");
		sb.append("     ?,               \n");//?
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     sysdate,               \n");
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
	
   
   @Override
   public int doUpdate(ReviewVO vo) {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE comment_tb	 \n");
		sb.append("SET                   \n");
		sb.append("    content = ?,      \n");
		sb.append("    mod_dt = SYSDATE  \n");
		sb.append("WHERE                 \n");
		sb.append("    review_seq = ?   \n");
		LOG.debug("=param=" + vo);
		LOG.debug("========================");

		Object[] args = { vo.getContext(), vo.getReview_seq() };
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag=" + flag);
		return flag;
	}
   
	
	
	@Override
	public ReviewVO doSelectOne(int seq) {
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
		sb.append(" FROM reivew     \n");
		sb.append(" WHERE review_seq = ?   \n");
		
		LOG.debug("-----------------------------");
		//LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + seq);
		LOG.debug("-----------------------------");	
		
		Object args[] = {seq};
		outVO = (ReviewVO)this.jdbcTemplate.queryForObject(sb.toString(), 
															args, 
															rowMapper);
		
		LOG.debug("==========================");
		LOG.debug("=outVO="+outVO);
		LOG.debug("==========================");

		return outVO;
	}
	
	@Override
	public ReviewVO doSelectOneById(String id) {
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
		sb.append(" WHERE writer = ?   \n");
		
		LOG.debug("-----------------------------");
		//LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + id);
		LOG.debug("-----------------------------");	
		
		Object args[] = {id};
		outVO = (ReviewVO)this.jdbcTemplate.queryForObject(sb.toString(), 
															args, 
															rowMapper);
		
		LOG.debug("==========================");
		LOG.debug("=outVO="+outVO);
		LOG.debug("==========================");

		return outVO;
	}
	
	
	
	
	
	/**
	 * 
	 * @param div
	 * @param searchWord
	 * @return
	 */
	
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
	
	
	
	/**
	 * 삭제
	 * @param ?
	 * @return
	 */
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

		Object[] args = { review };
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag:"+flag);
		
		return flag;
	}

	
	
	
}
