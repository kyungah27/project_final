package com.uver.service;

import java.util.List;

import com.uver.cmn.Search;
import com.uver.vo.EventVO;

public interface EventService {

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
	public int doDelte(EventVO event);
	
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
	public EventVO doSelectOne(int eventSeq);
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public List<EventVO> doSelectList(Search search);
}
