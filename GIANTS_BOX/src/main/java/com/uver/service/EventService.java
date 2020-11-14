package com.uver.service;

import java.util.List;

import com.uver.cmn.Search;
import com.uver.vo.EventVO;

public interface EventService {
	
	
	public int doInsertGetSeq(EventVO event);
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public int doInsert(EventVO event);
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public int doDelete(EventVO event);
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public int doUpdate(EventVO event);
	
	/**
	 * 
	 * @param eventSeq
	 * @return
	 */
	public EventVO doSelectOne(EventVO event);
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public List<EventVO> doSelectList(Search search);
}
