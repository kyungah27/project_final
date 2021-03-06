package com.uver.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.uver.cmn.Search;
import com.uver.dao.EventImgDaoImpl;
import com.uver.dao.ImgDaoImpl;
import com.uver.vo.EventImgVO;
import com.uver.vo.ImgVO;

@Service("eventImgService")
public class EventImgServiceImpl implements EventImgService {
	private static final Logger LOG = LoggerFactory.getLogger(EventImgServiceImpl.class);
	
	private final EventImgDaoImpl eventImgDao;
	private final ImgDaoImpl 	  imgDao;
	
	
	public EventImgServiceImpl(EventImgDaoImpl eventImgDao, ImgDaoImpl imgDao) {
		this.eventImgDao = eventImgDao;
		this.imgDao 	 = imgDao;
	}
	
	//-------------------------------------------
	
	@Override
	public int doSelectThumbnail(int eventSeq) {
		return eventImgDao.doSelectThumbnail(eventSeq);
	}
	

	@Override
	public int doInsert(EventImgVO eventImg) {
		int flag = 0;

		int imgSeq = imgDao.doInsert(eventImg.getImgVO());
		flag = eventImgDao.doInsert(new EventImgVO(imgSeq, eventImg.getEventSeq()));
		
		return flag;
	}
	
	
	
	@Override
	public EventImgVO addAndGet(EventImgVO eventImg) {

		int imgSeq = imgDao.doInsert(eventImg.getImgVO());
		eventImgDao.doInsert(new EventImgVO(imgSeq, eventImg.getEventSeq()));
		
		EventImgVO outVO = eventImgDao.doSelectOne(imgSeq);
		
		return outVO;
	}
	
	
	
	
	@Override
	public int doDelete(int imgSeq) {
		//---EventImg 테이블 데이터 동시에 삭제됨
		return imgDao.doDelete(imgSeq);
	}
	
	@Override
	public int doUpdate(int imgSeq) {
		return imgDao.doUpdate(imgDao.doSelectOne(imgSeq));
	}

	@Override
	public EventImgVO doSelectOne(int imgSeq) {
		return eventImgDao.doSelectOne(imgSeq);
	}

	@Override
	public List<EventImgVO> doSelectList(Search search) {
		return eventImgDao.doSelectList(search);
	}

	@Override
	public List<ImgVO> doSelectListById(Search search) {
		return imgDao.doSelectList(search);
	}


	@Override
	public int getMaxImgSeq(int eventSeq) {
		return eventImgDao.getMaxImgSeq(eventSeq);
	}

	@Override
	public EventImgVO doSelectLatestImg(int eventSeq) {
		return eventImgDao.doSelectLatestImg(eventSeq);
	}

	@Override
	public ImgVO doSelectDefault() {
		return imgDao.doSelectOne(707);
	}

	
	

}
