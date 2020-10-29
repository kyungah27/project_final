package com.uver.vo;

import com.uver.cmn.DTO;

public class EventImgVO extends DTO {

	private int 		EventSeq;	/** 이벤트 순번 */
	private int			imgSeq;		/** 이미지 순번 */
	private ImgVO 		imgVO;		/** ImgVO */
	
	public EventImgVO(int eventSeq, int imgSeq) {
		super();
		EventSeq = eventSeq;
		this.imgSeq = imgSeq;
	}
	
	
	public EventImgVO(int eventSeq, int imgSeq, ImgVO imgVO) {
		super();
		EventSeq = eventSeq;
		this.imgSeq = imgSeq;
		this.imgVO = imgVO;
	}


	public int getEventSeq() {
		return EventSeq;
	}

	public int getImgSeq() {
		return imgSeq;
	}

	public ImgVO getImgVO() {
		return imgVO;
	}


	@Override
	public String toString() {
		return "EventImgVO [EventSeq=" + EventSeq + ", imgSeq=" + imgSeq + ", imgVO=" + imgVO + ", getDiv()=" + getDiv()
				+ ", getNum()=" + getNum() + ", getTotalCnt()=" + getTotalCnt() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	
	
}
