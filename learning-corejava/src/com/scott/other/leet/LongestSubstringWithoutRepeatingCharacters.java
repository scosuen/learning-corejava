package com.scott.other.leet;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		test1("123");
		
//		isRepeat("www".toCharArray());
	}

	public static void test1(String str) {
		int longest = 0;

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				char[] charArray = str.substring(i, j + 1).toCharArray();
				if (isRepeat(charArray) == false)
					break;
				else {
					if (longest < charArray.length)
						longest = charArray.length;
				}
			}
		}
		
		System.out.println(longest);
	}

	public static boolean isRepeat(char[] charArray) {
		List<Character> chs = new ArrayList<Character>();
		for (char ch : charArray) {
			if (chs.contains(ch))
				return false;
			else
				chs.add(ch);
		}
		
		return true;
	}
}
