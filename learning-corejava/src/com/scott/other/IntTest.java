package com.scott.other;

public class IntTest {

	public static void main(String[] args) {
		// test1();
		// test2();
		test3();
	}

	public static void test1() {
		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

		System.out.println(f1 == f2);
		System.out.println(f3 == f4);
	}

	public static void test2() {
		Integer a = new Integer(3);
		Integer b = 3;
		Integer c = 3;

		System.out.println(a == b);
		System.out.println(b == c);
	}

	public static void test3() {
		System.out.println(1 << 1); // 相当于 1 * 2的1次方 = 2
		System.out.println(1 << 2); // 相当于 1 * 2的2次方 = 4
		System.out.println(1 << 3); // 相当于 1 * 2的3次方 = 8
		
		System.out.println(16 >> 1); // 16 / 2的1次方 = 8
		System.out.println(16 >> 2); // 16 / 2的2次方 = 4
		System.out.println(16 >> 3); // 16 / 2的3次方 = 2
	}

}
