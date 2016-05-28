package com.scott.collection.list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {

	public static void main(String args[]) {

		CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<String>();
		threadSafeList.add("Java");
		threadSafeList.add("J2EE");
		threadSafeList.add("Collection");

		Iterator<String> failSafeIterator = threadSafeList.iterator();
		while (failSafeIterator.hasNext()) {
			System.out.printf("Read from CopyOnWriteArrayList : %s %n", failSafeIterator.next());
//			failSafeIterator.remove(); // not supported in CopyOnWriteArrayList
										// in Java
		}
		
		for (String str : threadSafeList) {
			System.out.println(str);
		}
	}

}
