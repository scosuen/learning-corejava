package com.scott.design_pattern.singleton.achieve_by_enum;

public enum MySingletonNonInterface {
	INSTANCE;
	
	private int count;
	
	public void addC () {
		count++;
	}
	
	public int getC () {
		return count;
	}
	
    private MySingletonNonInterface() {
        System.out.println("Here");
    }
}
