package com.scott.other;

import java.util.Scanner;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		while (read.hasNext()) {
			System.out.println(read.next());
		}
		test1();
	}

	public static void test1() {
		Stack<String> stack = new Stack<String>();

		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");

		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
