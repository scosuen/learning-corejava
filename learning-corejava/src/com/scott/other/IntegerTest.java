package com.scott.other;

public class IntegerTest {

	public static void main(String[] args) {
		Integer i1 = new Integer(1), i2 = new Integer(1);
		Integer i3 = 1, i4 = 1, i5 = Integer.valueOf("1");
		Integer i6 = 211, i7 = 211;
		
		System.out.println(i6 == i7);
				
		System.out.println(i3 == i4);
		System.out.println(i3 == i5);

		System.out.println(i1 == i2);
	}

}
