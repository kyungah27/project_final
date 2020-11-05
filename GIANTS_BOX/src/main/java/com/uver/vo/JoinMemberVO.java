package com.uver.vo;

public class JoinMemberVO extends JoinVO {

	private String userId;
	/**이름*/
	private String name;
	
	public JoinMemberVO() {
		
	}
	
	public JoinMemberVO(String userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "JoinMemberVO [userId=" + userId + ", name=" + name + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
