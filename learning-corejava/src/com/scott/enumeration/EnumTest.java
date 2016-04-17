package com.scott.enumeration;

public class EnumTest {
	
	public static void main(String[] args) {
//		System.out.println(City.Quebec_City);
		
		for (User user : User.values()) {
			System.out.println(user + " " + user.getPwd() + " " + user.getAge());
		}
	}

}
