package com.uver.service;

import java.util.List;

import com.uver.cmn.Search;
import com.uver.vo.EventImgVO;
import com.uver.vo.ImgVO;
	
public interface EventImgService {

	public int doInsert(EventImgVO eventImg);
	
	public int doDelete(int imgSeq);
	
	public int doUpdate(EventImgVO eventImg);
	
	public ImgVO doSelectOne(int imgSeq);
	
	public List<EventImgVO> doSelectList(Search search);

	public List<EventImgVO> doSelectAll(int eventSeq);

}
