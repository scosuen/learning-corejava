package com.scott.other;

public class StringTest {
	
	public static void main(String[] args) {
		System.out.println(getFirst("1234"));
		System.out.println(getLast("1234"));
		
		System.out.println(indexOf("eqwer", "e"));
		
		System.out.println(charAt("eqwer", 3));
	}
	
	static public String getFirst (String str) {
		return str.substring(0, 1);
	}
	
	static public String getLast (String str) {
		return str.substring(str.length()-1);
	}
	
	static public int indexOf (String str, String ch) {
		return str.indexOf(ch);
	}
	
	static public char charAt (String str, int index) {
		return str.charAt(index);
	}
	
	

}
