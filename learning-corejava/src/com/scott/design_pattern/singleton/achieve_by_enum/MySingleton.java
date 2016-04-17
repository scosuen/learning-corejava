package com.scott.design_pattern.singleton.achieve_by_enum;

public enum MySingleton implements IMySingleton {
	INSTANCE {
		private int c = 0;
		
		@Override
		public void doSomething() {
			c++;
			System.out.println("do something. c++");
		}
		
		@Override
		public int getC () {
			return c;
		}
	};
	
	public static IMySingleton getInstance() {
	    return MySingleton.INSTANCE;
	}
}
