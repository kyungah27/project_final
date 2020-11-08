package com.uver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uver.cmn.Search;
import com.uver.dao.EventDaoImpl;
import com.uver.vo.EventVO;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventDaoImpl eventDaoImpl;

	@Override
	public int doInsert(EventVO event) {
		return eventDaoImpl.doInsert(event);
	}

	@Override
	public int doDelte(EventVO event) {
		return eventDaoImpl.doDelete(event);
	}

	@Override
	public int doUpdate(EventVO event) {
		return eventDaoImpl.doUpdate(event);
	}

	@Override
	public EventVO doSelectOne(int eventSeq) {
		// TODO Auto-generated method stub
		return eventDaoImpl.doSelectOne(eventSeq);
	}

	@Override
	public List<EventVO> doSelectList(Search search) {
		return eventDaoImpl.doSelectList(search);
	}

}
