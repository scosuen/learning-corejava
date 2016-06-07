package com.scott.other.algorithm;

import java.util.Stack;

public class ReverseWords {
	
	public static void main(String[] args) {
		String str = "how are you";
		test1(str);
	}
	
	public static void test1 (String str) {
		
		Stack<String> stack = new Stack<String>();
		
		for (String s : str.split(" ")) {
			stack.push(s);
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

}
