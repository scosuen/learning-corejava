package com.scott.other.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Palindrome {

	public static void main(String[] args) {

		String string = "31213";

		System.out.println(test1(string));
		
		System.out.println(test2(string));
		
	}

	public static boolean test1(String number) {
		List<String> l = new ArrayList<String>();
		Stack<String> s = new Stack<String>();

		for (char c : number.toCharArray()) {
			l.add(String.valueOf(c));
			s.push(String.valueOf(c));
		}

		for (String ch : l) {
			if (!ch.equals(s.pop()))
				return false;
		}

		return true;
	}

	public static boolean test2(String number) {
		while (number.length() > 1) {
			if (!number.endsWith(number.substring(0, 1)))
				return false;
			number = number.substring(1, number.length() - 1);
		}
		return true;
	}

}
