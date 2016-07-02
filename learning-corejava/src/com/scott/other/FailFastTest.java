package com.scott.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>() {
			{
				add("3");
				add("1");
				add("4");
				add("2");
				add("3");
				add("5");
				add("2");
			}
		};
		
		Iterator<String> i = list.iterator();
		
		while (i.hasNext()) {
			String s = i.next();
			if (s.equals("2"))
//				list.remove(s);
				i.remove();
		}
		
		
		System.out.println(list);
	}

}
