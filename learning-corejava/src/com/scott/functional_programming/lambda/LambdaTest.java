package com.scott.functional_programming.lambda;

public class LambdaTest {
	
	public static void main(String[] args) {
		LambdaTest.runThreadUseLambda();
	}

	public static void runThreadUseLambda() {
		// Runnable是一个函数接口，只包含了有个无参数的，返回void的run方法；
		// 所以lambda表达式左边没有参数，右边也没有return，只是单纯的打印一句话
		new Thread(() -> System.out.println("New thread lambda test")).start();
	}
}
