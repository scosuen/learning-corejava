package com.scott.design_pattern.singleton;

public class LazyloadSingleton {
	private static class SingletonHolder {
		private static final LazyloadSingleton INSTANCE = new LazyloadSingleton();
	}

	private LazyloadSingleton() {
	}

	public static final LazyloadSingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
