package com.scott.functional_programming.lambda;

public class LambdaTest {
	
	public static void main(String[] args) {
		LambdaTest.runThreadUseLambda();
	}

	public static void runThreadUseLambda() {
		// Runnable��һ�������ӿڣ�ֻ�������и��޲����ģ�����void��run������
		// ����lambda���ʽ���û�в������ұ�Ҳû��return��ֻ�ǵ����Ĵ�ӡһ�仰
		new Thread(() -> System.out.println("New thread lambda test")).start();
	}
}
