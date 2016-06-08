package com.scott.innerclass;

public class Test {

	public static void main(String[] args) {
		OuterClass outerClassTest = new OuterClass();
		System.out.println(outerClassTest.getInnerInstance().getInnerString());
	}

}
