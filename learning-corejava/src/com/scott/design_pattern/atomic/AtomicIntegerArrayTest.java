package com.scott.design_pattern.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

	static int[] value = new int[] { 1, 2 };

	static AtomicIntegerArray ai = new AtomicIntegerArray(value);

	public static void main(String[] args) {
		ai.getAndSet(0, 3);
		System.out.println(ai.get(0) + ", " + ai.get(1));
		System.out.println(value[0] + ", " + value[1]);
	}

}
