package com.scott.innerclass;

import com.scott.innerclass.OuterClass.InnerClass;

public class Test {

	public static void main(String[] args) {
		OuterClass outerClassTest = new OuterClass();
		System.out.println(outerClassTest.getInnerInstance().getInnerString());
		
		InnerClass innerClass = new OuterClass().new InnerClass();
		
	}

}
