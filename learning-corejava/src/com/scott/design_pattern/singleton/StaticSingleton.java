package com.scott.design_pattern.singleton;

public class StaticSingleton {

	// �����ʱ�ͳ�ʼ��
	private static final StaticSingleton instance = new StaticSingleton();

	private StaticSingleton() {
	}

	public static StaticSingleton getInstance() {
		return instance;
	}

}
