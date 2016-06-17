package com.scott.enumeration;

public enum User {
	
	SunYing("1111qqq", "32"),
	Ke("222www", "22"),
	Scott ("333eeee", "33");
	
	private User (String pwd, String age) {
		this.pwd = pwd;
		this.age = age;
	}
	
	private final String age;
	private final String pwd;
	
	public String getPwd() {
		return pwd;
	}
	public String getAge() {
		return age;
	}

}
