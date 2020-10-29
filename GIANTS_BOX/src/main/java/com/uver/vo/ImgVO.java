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




	public ImgVO(int imgSeq, String originName, String serverName, String imgType, int imgSize, String isThumbnail,
			String regDt, String regId) {
		super();
		this.imgSeq = imgSeq;
		this.originName = originName;
		this.serverName = serverName;
		this.imgType = imgType;
		this.imgSize = imgSize;
		this.isThumbnail = isThumbnail;
		this.regDt = regDt;
		this.regId = regId;
	}



	public int getImgSeq() {
		return imgSeq;
	}



	public String getOriginName() {
		return originName;
	}


	public String getServerName() {
		return serverName;
	}


	public String getImgType() {
		return imgType;
	}



	public int getImgSize() {
		return imgSize;
	}



	public String getIsThumbnail() {
		return isThumbnail;
	}



	public String getRegDt() {
		return regDt;
	}



	public String getRegId() {
		return regId;
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
