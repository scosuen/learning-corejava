package com.scott.other;

public class StringTest {

	public static void main(String[] args) {
		System.out.println(getFirst("1234"));
		System.out.println(getLast("1234"));

		System.out.println(indexOf("eqwer", "e"));

		System.out.println(charAt("eqwer", 3));
		
		test1();
	}

	static public String getFirst(String str) {
		return str.substring(0, 1);
	}

	static public String getLast(String str) {
		return str.substring(str.length() - 1);
	}

	static public int indexOf(String str, String ch) {
		return str.indexOf(ch);
	}

	static public char charAt(String str, int index) {
		return str.charAt(index);
	}

	public static void test1() {
		String a = "1";
		String b = "1";
		String c = new String("1");
		
		String e = "11";
		String d = "1" + "1";
		
		System.out.println("ab: " + (a == b));
		System.out.println("cb: " + (c == b));
		System.out.println("c.intern b: " + (c.intern() == b));
		
		System.out.println("ed: " + (e == d));
		
	}
}
