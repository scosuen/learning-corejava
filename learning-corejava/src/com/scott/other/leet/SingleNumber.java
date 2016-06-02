package com.scott.other.leet;

public class SingleNumber {
	
	public static void main(String[] args) {
		System.out.println(test1("112233445566"));
	}
	
	public static String test1 (String str) {
		
		String foo = null;
		while (str.length() > 0) {
			foo = str.substring(0, 1);
			str = str.substring(1);
			
			if (!str.contains(foo))
				break;
			
			str = str.replace(foo, "");
			foo = null;
			
		}
		
		return foo;
	}

}
