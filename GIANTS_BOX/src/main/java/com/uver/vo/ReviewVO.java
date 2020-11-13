package com.uver.vo;

public class ReviewVO {
	
	private int review_seq;	
	
	private int eventSeq;	
	
	private String writer;
	
	private String title;	
	
	private String context;
	
	private String reg_dt;
	
	private String review_div;
	
	private String mod_dt;

	public ReviewVO() {
		super();
	}

	public ReviewVO(int review_seq, int eventSeq, String writer, String title, String context, String reg_dt,
			String review_div, String mod_dt) {
		super();
		this.review_seq = review_seq;
		this.eventSeq = eventSeq;
		this.writer = writer;
		this.title = title;
		this.context = context;
		this.reg_dt = reg_dt;
		this.review_div = review_div;
		this.mod_dt = mod_dt;
	}

	public int getReview_seq() {
		return review_seq;
	}

	public void setReview_seq(int review_seq) {
		this.review_seq = review_seq;
	}

	public int getEventSeq() {
		return eventSeq;
	}

	public void setEventSeq(int eventSeq) {
		this.eventSeq = eventSeq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getReview_div() {
		return review_div;
	}

	public void setReview_div(String review_div) {
		this.review_div = review_div;
	}

	public String getMod_dt() {
		return mod_dt;
	}

	public void setMod_dt(String mod_dt) {
		this.mod_dt = mod_dt;
	}

	@Override
	public String toString() {
		return "ReviewVO [review_seq=" + review_seq + ", eventSeq=" + eventSeq + ", writer=" + writer + ", title="
				+ title + ", context=" + context + ", reg_dt=" + reg_dt + ", review_div=" + review_div + ", mod_dt="
				+ mod_dt + "]";
	}

	
	
}
