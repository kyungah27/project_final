package com.uver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uver.vo.EventVO;

@Repository("eventDaoImpl")
public class EventDaoImpl {

	private static final Logger LOG = LoggerFactory.getLogger(EventDaoImpl.class);
	
	private final JdbcTemplate jdbcTemplate;
	
	public EventDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	RowMapper<EventVO> rowMapper = new RowMapper<EventVO>(){

		@Override
		public EventVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EventVO outVO = new EventVO();
			
			outVO.setEventSeq(rs.getInt("event_seq"));
			outVO.setUserId(rs.getString("user_id"));
			outVO.setEventNm(rs.getString("event_nm"));
			outVO.setContent(rs.getString("content"));
			outVO.setCapacity(rs.getInt("capacity"));
			outVO.setMovieInfo(rs.getString("movie_info"));
			outVO.setStartDt(rs.getString("start_dt"));
			outVO.setEndDt(rs.getString("end_dt"));
			outVO.setLocation(rs.getString("location"));
			outVO.setRegDt(rs.getString("reg_dt"));
			outVO.setModDt(rs.getString("mod_dt"));
			
			return outVO;
		}
		
	};
	
	public int doInsert(EventVO event) {
		
		int flag = 0;
		Object[] args = { event.getEventSeq(),
						  event.getUserId(),
						  event.getEventNm(),
						  event.getContent(),
						  event.getCapacity(),
						  event.getMovieInfo(),
						  event.getStartDt(),
						  event.getEndDt(),
						  event.getLocation()
						};
 		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO event (		\n");
		sb.append("    event_seq,           \n");
		sb.append("    user_id,             \n");
		sb.append("    event_nm,            \n");
		sb.append("    content,             \n");
		sb.append("    capacity,            \n");
		sb.append("    movie_info,          \n");
		sb.append("    start_dt,            \n");
		sb.append("    end_dt,              \n");
		sb.append("    location,            \n");
		sb.append("    reg_dt,              \n");
		sb.append("    mod_dt               \n");
		sb.append(") VALUES (               \n");
		sb.append("    ?,                 \n");
		sb.append("    ?,                 \n");
		sb.append("    ?,                 \n");
		sb.append("    ?,                 \n");
		sb.append("    ?,                 \n");
		sb.append("    ?,                 \n");
		sb.append("    ?,                 \n");
		sb.append("    ?,                 \n");
		sb.append("    ?,                 \n");
		sb.append("    sysdate,                 \n");
		sb.append("    sysdate                 \n");
		sb.append(")                        \n");
		
		LOG.debug("===========================");
		LOG.debug("=param=\n"+event);
		LOG.debug("===========================");
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag="+flag);
		
		return flag;
	}
}
