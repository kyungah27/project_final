package com.uver.vo;

import com.uver.cmn.DTO;

public class ImgVO extends DTO {

	private int 	imgSeq;			/** 이미지 순번 */
	private String 	originName;		/** 첨부이름 */
	private String 	serverName;		/** 서버저장이름 */
	private String 	type;			/** 확장자 */
	private int 	size;			/** 크기 */
	private String 	isThumbnail;	/** 썸네일여부 */
	private String 	regDt;			/** 등록일 */
	private String 	regId;			/** 등록자 */
	
	
	public ImgVO() {
		super();
	}
	
	
	public ImgVO(int imgSeq, String originName, String serverName, String type, int size, String isThumbnail,
			String regDt, String regId) {
		super();
		this.imgSeq = imgSeq;
		this.originName = originName;
		this.serverName = serverName;
		this.type = type;
		this.size = size;
		this.isThumbnail = isThumbnail;
		this.regDt = regDt;
		this.regId = regId;
	}


	public int getImgSeq() {
		return imgSeq;
	}


	public void setImgSeq(int imgSeq) {
		this.imgSeq = imgSeq;
	}


	public String getOriginName() {
		return originName;
	}


	public void setOriginName(String originName) {
		this.originName = originName;
	}


	public String getServerName() {
		return serverName;
	}


	public void setServerName(String serverName) {
		this.serverName = serverName;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public String getIsThumbnail() {
		return isThumbnail;
	}


	public void setIsThumbnail(String isThumbnail) {
		this.isThumbnail = isThumbnail;
	}


	public String getRegDt() {
		return regDt;
	}


	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}


	public String getRegId() {
		return regId;
	}


	public void setRegId(String regId) {
		this.regId = regId;
	}


	@Override
	public String toString() {
		return "ImgVO [imgSeq=" + imgSeq + ", originName=" + originName + ", serverName=" + serverName + ", type="
				+ type + ", size=" + size + ", isThumbnail=" + isThumbnail + ", regDt=" + regDt + ", regId=" + regId
				+ ", getDiv()=" + getDiv() + ", getNum()=" + getNum() + ", getTotalCnt()=" + getTotalCnt()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	
}
