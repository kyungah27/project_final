package com.uver.vo;

public class ReviewVO {
	
	private int review_seq;	
	
	private String writer;
	
	private String title;	
	
	private String context;
	
	private String reg_dt;
	
	private int div;
	
	private String mod_dt;

	public ReviewVO() {
		super();
	}

	public ReviewVO(int review_seq, String writer, String title, String context, String reg_dt, int div,
			String mod_dt) {
		super();
		this.review_seq = review_seq;
		this.writer = writer;
		this.title = title;
		this.context = context;
		this.reg_dt = reg_dt;
		this.div = div;
		this.mod_dt = mod_dt;
	}

	public int getReview_seq() {
		return review_seq;
	}

	public void setReview_seq(int review_seq) {
		this.review_seq = review_seq;
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

	public int getDiv() {
		return div;
	}

	public void setDiv(int div) {
		this.div = div;
	}

	public String getMod_dt() {
		return mod_dt;
	}

	public void setMod_dt(String mod_dt) {
		this.mod_dt = mod_dt;
	}

	@Override
	public String toString() {
		return "ReviewVO [review_seq=" + review_seq + ", writer=" + writer + ", title=" + title + ", context=" + context
				+ ", reg_dt=" + reg_dt + ", div=" + div + ", mod_dt=" + mod_dt + "]";
	}

	
	
}
