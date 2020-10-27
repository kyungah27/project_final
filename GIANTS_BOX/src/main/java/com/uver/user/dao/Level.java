package com.uver.user.dao;

public enum Level {
    //BASIC(1),SILVER(2),GOLD(3);//세 개의 이늄 오브젝트
	GOLD(3,null),SILVER(2,GOLD),BASIC(1,SILVER);
	
	private final int value ;
	private final Level next;//다음 단계 레벨 정보를 저장.
	
	
	Level(int value,Level next){
		this.value = value;
		this.next = next;
	}
	
	//값
	public int intValue() {
		return this.value;
	}
	
	public Level nextLevel() {
		return this.next;
	}
	
	
	
	//BASIC
	public static Level valueOf(int value) {
		
		
		switch(value) {
			case 1: return BASIC;
			case 2: return SILVER;
			case 3: return GOLD;
			default:
				throw new AssertionError("Unknown value : "+value);
		}
	}
	
	
	
}
