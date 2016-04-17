package com.scott.design_pattern.singleton.achieve_by_enum;

public class SingletonTest {

	public static void main(String[] args) {
		IMySingleton instance = MySingleton.getInstance();
		
		instance.doSomething();
		instance.doSomething();
		System.out.println(instance.getC());
		
		
//		MySingletonNonInterface instance = MySingletonNonInterface.INSTANCE;
//		instance.addC();
//		instance.addC();
//		System.out.println(instance.getC());
	}
	
}
