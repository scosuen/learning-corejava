package com.scott.design_pattern.singleton;

public class DoubleCheckSingleton {

	private volatile static DoubleCheckSingleton singleton = null;

	private DoubleCheckSingleton() {
		
	}

	public static DoubleCheckSingleton getInstance() {
		if (singleton == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (singleton == null) {
					singleton = new DoubleCheckSingleton();
				}
			}
		}
		return singleton;
	}

}
