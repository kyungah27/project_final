package com.uver.user.dao;

public class User {
	
	/**사용자 ID */
	private String u_id;
	/**이름  */
	private String name;
	/**비밀번호 */
	private String passwd;
	
	/**레벨:BASIC,SILVER,GOLD*/
	private Level  level;  
	
	/**로그인 회수 */
	private int     login;
	
	/**추천 회수 */
    private int     recommend;
    
    /**mail */
    private String mail; 
    
    /**등록일 */
    private String regDt;
    
	
	
	public User() {}

	public User(String u_id, String name, String passwd) {
		super();
		this.u_id = u_id;
		this.name = name;
		this.passwd = passwd;
	}
	
	public int getLogin() {
		return login;
	}

	public User(String u_id, String name, String passwd, Level level, int login, int recommend, String mail, String regDt) {
	super();
	this.u_id = u_id;
	this.name = name;
	this.passwd = passwd;
	this.level = level;
	this.login = login;
	this.recommend = recommend;
	this.mail = mail;
	this.regDt = regDt;
}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", name=" + name + ", passwd=" + passwd + ", level=" + level + ", login=" + login
				+ ", recommend=" + recommend + ", mail=" + mail + ", regDt=" + regDt + "]";
	}

	
	public void upgradeLevel() {
		Level nextLevel = this.level.nextLevel();
		
		if(null == nextLevel) {
			throw new IllegalStateException(this.level+"은 업그레이드가 불가능 합니다.");
		}else {
			this.level = nextLevel;
		}
	}

	
	
}









