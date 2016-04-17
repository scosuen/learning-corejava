package com.scott.design_pattern.singleton;

public class StaticSingleton {

	// 类加载时就初始化
	private static final StaticSingleton instance = new StaticSingleton();

	private StaticSingleton() {
	}

	public static StaticSingleton getInstance() {
		return instance;
	}

}
