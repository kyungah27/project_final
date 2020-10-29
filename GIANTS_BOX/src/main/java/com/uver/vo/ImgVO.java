package com.uver.vo;

import com.uver.cmn.DTO;

public class ImgVO extends DTO {

	private int 	imgSeq;			/** 이미지 순번 */
	private String 	originName;		/** 첨부이름 */
	private String 	serverName;		/** 서버저장이름 */
	private String 	imgType;			/** 확장자 */
	private int 	imgSize;			/** 크기 */
	private String	isThumbnail;	/** 썸네일여부 */
	private String 	regDt;			/** 등록일 */
	private String 	regId;			/** 등록자 */
	
	
	public ImgVO() {
		super();
	}


	public ImgVO(String originName, String serverName, String imgType, int imgSize, String isThumbnail,
			String regId) {
		super();
//		this.imgSeq = imgSeq;
		this.originName = originName;
		this.serverName = serverName;
		this.imgType = imgType;
		this.imgSize = imgSize;
		this.isThumbnail = isThumbnail;
//		this.regDt = regDt;
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


	public String getImgType() {
		return imgType;
	}


	public void setImgType(String imgType) {
		this.imgType = imgType;
	}


	public int getImgSize() {
		return imgSize;
	}


	public void setImgSize(int imgSize) {
		this.imgSize = imgSize;
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
		return "ImgVO [imgSeq=" + imgSeq + ", originName=" + originName + ", serverName=" + serverName + ", imgType="
				+ imgType + ", imgSize=" + imgSize + ", isThumbnail=" + isThumbnail + ", regDt=" + regDt + ", regId="
				+ regId + ", getDiv()=" + getDiv() + ", getNum()=" + getNum() + ", getTotalCnt()=" + getTotalCnt()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	
}
