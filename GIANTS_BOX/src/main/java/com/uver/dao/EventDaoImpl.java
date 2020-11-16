package com.uver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uver.cmn.Search;
import com.uver.vo.EventVO;

@Repository
public class EventDaoImpl {

	private static final Logger LOG = LoggerFactory.getLogger(EventDaoImpl.class);
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE = "com.uver.event";
	
	/**
	 * 등록
	 * @param event
	 * @return 1(성공) / 0(실패) 
	 */
	public int doInsert(EventVO event) {
		LOG.debug("===========================");
		LOG.debug("=doInsert=");
		LOG.debug("===========================");
		
		String statement = NAMESPACE+".doInsert";
		LOG.debug("=statement="+statement);
		LOG.debug("=event="+event);
		
		int flag = sqlSessionTemplate.insert(statement, event);
		
		LOG.debug("=flag="+flag);
		
		return flag;
	}

	
	
	/**
	 * 등록 후 seq 값 얻기
	 * @param event
	 * @return eventSeq
	 */
	public int doInsertGetSeq(EventVO event) {
		LOG.debug("=doInsert=");
		LOG.debug("===========================");
		
		String statement = NAMESPACE+".doInsert";
		LOG.debug("=statement="+statement);
		LOG.debug("=event="+event);
		int flag = sqlSessionTemplate.insert(statement, event);
		int seq = event.getEventSeq();
		LOG.debug("=flag="+flag);
		LOG.debug("=seq="+seq);
		
		return seq;
	}
	
	
	
	/**
	 * 삭제
	 * @param event
	 * @return 1(성공) / 0(실패)
	 */
	public int doDelete(EventVO event) {
		LOG.debug("===========================");
		LOG.debug("=doDelete=");
		LOG.debug("===========================");
		
		String statement = NAMESPACE+".doDelete";
		LOG.debug("=statement="+statement);
		LOG.debug("=event="+event);
		
		int flag = sqlSessionTemplate.delete(statement, event);
		LOG.debug("=flag="+flag);
		
		return flag;
	}
	
	/**
	 * 수정
	 * @param event
	 * @return 1(성공) / 0(실패)
	 */
	public int doUpdate(EventVO event) {
		LOG.debug("===========================");
		LOG.debug("=doUpdate=");
		LOG.debug("===========================");
		
		String statement = NAMESPACE+".doUpdate";
		LOG.debug("=statement="+statement);
		
		int flag = sqlSessionTemplate.update(statement, event);
		LOG.debug("=flag="+flag);
		
		return flag;
	}
	
	/**
	 * 단건조회
	 * @param eventSeq
	 * @return
	 */
	public EventVO doSelectOne(EventVO event) {
		LOG.debug("===========================");
		LOG.debug("=doSelectOne=");
		LOG.debug("===========================");
		
		String statement = NAMESPACE+".doSelectOne";
		LOG.debug("=statement="+statement);
		LOG.debug("=event="+event);
		
		EventVO outVO = this.sqlSessionTemplate.selectOne(statement,event);
		LOG.debug("=outVO="+outVO);
		
		return outVO;
	}
	
	public List<EventVO> doSelectList(Search search){
		LOG.debug("=====================");
		LOG.debug("=doSelectList=");
		LOG.debug("=====================");
		
		String statement = NAMESPACE + ".doSelectList";
		LOG.debug("=statement="+statement);
		LOG.debug("=param="+search);

		List<EventVO> list = this.sqlSessionTemplate.selectList(statement, search);
		for(EventVO vo :list) {
			LOG.debug("=vo="+vo);
		}
		
		return list;
	}
}
