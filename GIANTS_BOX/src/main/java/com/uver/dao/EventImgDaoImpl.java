package com.uver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uver.vo.EventImgVO;


@Repository("eventImgDao")
public class EventImgDaoImpl implements EventImgDao {
	private static final Logger LOG = LoggerFactory.getLogger(EventImgDaoImpl.class);
    
    private final JdbcTemplate jdbcTemplate;
    
    public EventImgDaoImpl(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
    }
    
    //---row mapper------------------------------------------------
    RowMapper<EventImgVO> rowMapper= new RowMapper<EventImgVO>() {
		@Override
		public EventImgVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EventImgVO outVO = new EventImgVO(
						rs.getInt("event_seq"),
						rs.getInt("img_seq")
						);
			
			return outVO;
		}
   }; //---row mapper end
    
    
   //---메서드----------------------------------------------------------
	@Override
	public int doInsert(EventImgVO eventImg) {
		int flag 	  = 0;	    
	    Object[] args = { 
	    				  eventImg.getEventSeq(),
	    				  eventImg.getImgSeq(),
	    				};
	    
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO event_image (	\n");
		sb.append("    event_seq,	            \n");
		sb.append("    img_seq	                \n");
		sb.append(") VALUES (	                \n");
		sb.append("    ?,	                    \n");
		sb.append("    ?	                    \n");
		sb.append(")	                        \n");
		
		LOG.debug("-----------------------------");
		LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + eventImg);
		LOG.debug("-----------------------------");			
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("[flag] "+flag);

		return flag;
	}
	
	

	

	@Override
	public int doDelete(EventImgVO eventImg) {
		int flag 	  = 0;	    
//	    Object[] args = { imgSeq };
//	    
//		StringBuilder sb = new StringBuilder();
//		sb.append("DELETE FROM image \n");
//		sb.append("WHERE             \n");
//		sb.append("    img_seq = ?   \n");
//		
//		LOG.debug("-----------------------------");
//		LOG.debug("[SQL]\n"   + sb.toString());
//		LOG.debug("[param]\n" + imgSeq);
//		LOG.debug("-----------------------------");			
//		
//		flag = this.jdbcTemplate.update(sb.toString(), args);
//		LOG.debug("[flag] "+flag);
//
		return flag;
	}

	@Override
	public EventImgVO doSelectOne(EventImgVO eventImg) {
		EventImgVO 	 outVO = null;	    
//	    Object[] args  = { seq };
//	    
//		StringBuilder sb = new StringBuilder();
//		sb.append("SELECT				\n");
//		sb.append("    img_seq,         \n");
//		sb.append("    origin_name,     \n");
//		sb.append("    server_name,     \n");
//		sb.append("    img_type,        \n");
//		sb.append("    img_size,        \n");
//		sb.append("    is_thumbnail,    \n");
//		sb.append("    reg_dt,          \n");
//		sb.append("    reg_id           \n");
//		sb.append("FROM                 \n");
//		sb.append("    image            \n");
//		sb.append("WHERE img_seq = ?    \n");
//		
//		LOG.debug("-----------------------------");
//		LOG.debug("[SQL]\n"   + sb.toString());
//		LOG.debug("[param]\n" + seq);
//		LOG.debug("-----------------------------");			
//		
//		outVO = (ImgVO) this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);
//		LOG.debug("[outVO]\n" + outVO);
//
		return outVO;
	}

	@Override
	public List<EventImgVO> doSelectList(EventImgVO eventImg) {
		List<EventImgVO> list = null;	    
//	    Object[] args  = { regId };
//	    
//		StringBuilder sb = new StringBuilder();
//		sb.append("SELECT				\n");
//		sb.append("    img_seq,         \n");
//		sb.append("    origin_name,     \n");
//		sb.append("    server_name,     \n");
//		sb.append("    img_type,        \n");
//		sb.append("    img_size,        \n");
//		sb.append("    is_thumbnail,    \n");
//		sb.append("    reg_dt,          \n");
//		sb.append("    reg_id           \n");
//		sb.append("FROM                 \n");
//		sb.append("    IMAGE            \n");
//		sb.append("WHERE reg_id = ?     \n");
//		sb.append("ORDER BY reg_dt DESC \n");
//		
//		LOG.debug("-----------------------------");
//		LOG.debug("[SQL]\n"   + sb.toString());
//		LOG.debug("[param]\n" + regId);
//		LOG.debug("-----------------------------");			
//		
//		list = (List<ImgVO>) this.jdbcTemplate.query(sb.toString(), args, rowMapper);
//		LOG.debug("-----------------------------");
//		for (ImgVO vo : list) {
//			LOG.debug("[vo] " + list);
//		}
//		LOG.debug("-----------------------------");
//		
		return list;
	}

	@Override
	public int count(EventImgVO eventImgVO) {
		int  cnt = 0;
//	    Object[] args  = { regId };
//		
//		StringBuilder  sb=new StringBuilder();
//		sb.append(" SELECT COUNT(*) cnt \n");
//		sb.append(" FROM IMAGE          \n");
//		sb.append(" WHERE reg_id = ?    \n");
//		LOG.debug("-----------------------------");
//		LOG.debug("[SQL]\n"   + sb.toString());
//		LOG.debug("[param]\n" + regId);
//		LOG.debug("-----------------------------");		
//		
//		cnt = this.jdbcTemplate.queryForObject(sb.toString(), args, Integer.class);
//		LOG.debug("-----------------------------");
//		LOG.debug("[count] "+cnt);
//		LOG.debug("-----------------------------");

    	return cnt;
	}
	
	
	
    
    
    

}
