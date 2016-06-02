package com.scott.other.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(){
			{
				add("111");
				add("111");
				add("111");
				add("111");
				add("222");
				add("333");
				add("444");
				add("444");
				add("444");
				add("555");
			}
		};
//		test1(list);
		test2(list);
	}

	private static void test1 (List<String> list) {
		String tempStr = null;
		System.out.println(list);
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			if (str.equals(tempStr))
				iterator.remove();
			else
				tempStr = str;
		}
		System.out.println(list);
	}
	
	private static void test2 (List<String> list) {
		Set<String> set = new HashSet<String>();
		set.addAll(list);
		
		System.out.println("set:" + set);
		
	}
}
