package com.ppp.vo;


public class Auth {
	private String id;
	private int level;
	
	public Auth(String id, int level) {
		this.id = id;
		this.level = level;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
