package com.scott.collection.compare;

public class User implements Comparable<User> {
	
	private int userId;
	private String username;
	private String email;
	private int age;
	
	public User () {
		
	}
	
	public User (int userId, String username, String email, int age) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.age = age;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("id:" + getUserId()).append(", user name: " + getUsername()).append(", email: " + getEmail());
		
		return str.toString();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(User user) {
		if (getAge() > user.getAge())
			return 1;
		else if (getAge() < user.getAge())
			return -1;
		else
			return 0;
	}

}
