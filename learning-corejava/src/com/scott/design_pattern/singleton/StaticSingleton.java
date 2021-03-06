package com.scott.design_pattern.singleton;

/**
 * 
 * thread safe
 * not lazy loading
 * @author Ying
 *
 */
public class StaticSingleton {

	// 类加载时就初始化
	private static final StaticSingleton instance = new StaticSingleton();

	private StaticSingleton() {
	}

	public static StaticSingleton getInstance() {
		return instance;
	}

}
