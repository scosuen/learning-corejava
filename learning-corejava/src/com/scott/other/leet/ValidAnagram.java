package com.scott.other.leet;

import java.util.Arrays;

public class ValidAnagram {
	
	public static void main(String[] args) {
		test1("anagram", "anagram");
	}
	
	public static void test1 (String str1, String str2) {
		char [] str1Arr = str1.toCharArray();
		char [] str2Arr = str2.toCharArray();
		
		Arrays.sort(str1Arr);
		Arrays.sort(str2Arr);
		
		System.out.println(Arrays.equals(str1Arr, str2Arr));
	}

}
