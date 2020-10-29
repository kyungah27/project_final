package com.uver.vo;

import com.uver.cmn.DTO;

//회원순번(PK)(FK)	member_seq(PK)(FK)	N/A	NUMBER(20)	NOT NULL
//이벤트순번(PK)(FK)	event_seq(PK)(FK)	N/A	NUMBER(20)	NOT NULL
//권한	priority	N/A	NUMBER(1)	NULL

public class JoinVO extends DTO {
	
	private int event_seq;
	private int member_seq;
	private int priority;
	
	public JoinVO() {
		
	}
	

	
	
	
	public JoinVO(int event_seq, int member_seq, int priority) {
		super();
		this.event_seq = event_seq;
		this.member_seq = member_seq;
		this.priority = priority;
	}





	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	public int getEvent_seq() {
		return event_seq;
	}
	public void setEvent_seq(int event_seq) {
		this.event_seq = event_seq;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return "JoinVO [member_seq=" + member_seq + ", event_seq=" + event_seq + ", priority=" + priority
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	

}
