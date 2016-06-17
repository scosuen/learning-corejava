package com.scott.algorithm;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeat {

	public static void main(String[] args) {
		
		String string = "aadcc";
//		System.out.println(test1(string));
		
		System.out.println(test2(string));

		// System.out.println("zass".charAt(3));
		// System.out.println("sdfsdf".indexOf('b'));
		// System.out.println("aadd".replaceFirst(String.valueOf('a'), ""));
	}

	public static List<Character> test2(String str) {
		List<Character> chars = new ArrayList<Character>();

		while (str.length() > 0) {
			char c = str.charAt(0);
			str = str.substring(1);
			
			if (str.indexOf(c) < 0)
				chars.add(c);
			else 
				str = str.replace(String.valueOf(c), "");
		}
		
		return chars;
	}

	public static List<Character> test1(String str) {
		List<Character> chars = new ArrayList<Character>();
		for (char c : str.toCharArray()) {
			if (count2(str, c) <= 1)
				chars.add(c);
		}

		return chars;
	}

	private static int count(String str, char c) {
		int count = 0;

		while (str.indexOf(c) >= 0) {
			count++;
			str = str.replaceFirst(String.valueOf(c), "");
		}

		return count;
	}

	private static int count2(String str, char ch) {
		int count = 0;
		for (char c : str.toCharArray()) {
			if (c == ch)
				count++;
		}
		return count;

	}

}
