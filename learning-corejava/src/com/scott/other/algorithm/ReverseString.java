package com.scott.other.algorithm;

import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		String string = "hello world.";
		test1(string);
	}

	public static void test1(String string) {
		Stack<String> stack = new Stack<String>();
		for (char c : string.toCharArray()) {
			stack.push(String.valueOf(c));
		}

		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty())
			result.append(stack.pop());

		System.out.println(result);
	}
	
}
