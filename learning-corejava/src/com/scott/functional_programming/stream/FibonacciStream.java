package com.scott.functional_programming.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.TransferHandler.TransferSupport;

import org.omg.CORBA.PUBLIC_MEMBER;

public class FibonacciStream {
	private static Long a = null;
	private static Long b = null;
	private static Long c = null;

	public static void main(String[] args) {
		// test1();
		// test2();
		test3(3L, 12L);
	}

	public static void test3(Long from, Long to) {
		Stream<Long> fibonacci = Stream.generate(() -> {
			if (a == null) {
				a = 0L;
				return a;
			} else if (b == null) {
				b = 1L;
				return b;
			} else {
				c = a + b;
				a = b;
				b = c;
			}
			return c;
		});
		
		fibonacci.skip(from).limit(to).forEach((Long x) -> {
			System.out.println(x);
		});
	}

	public static void test1() {
		Stream<Long> fibonacci = Stream.generate(new FibonacciSupplier());

		List<Long> list = new ArrayList<Long>();

		fibonacci.limit(50).forEach((Long x) -> {
			list.add(x);
		});

		// list = fibonacci.skip(5).limit(10).collect(Collectors.toList());
		System.out.println(list);
	}

	public static void test2() {
		List<Long> list = new ArrayList<Long>();

		Long a = 0L;
		Long b = 1L;
		Long x = null;

		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				list.add(0L);
			} else if (i == 1) {
				list.add(1L);
			} else {
				x = a + b;
				a = b;
				b = x;
				list.add(x);
			}
		}

		System.out.println(list);

	}

}

class FibonacciSupplier implements Supplier<Long> {

	Long a = null;
	Long b = null;
	Long x = null;

	@Override
	public Long get() {
		if (a == null) {
			a = 0L;
			return a;
		} else if (a == 0L) {
			a = 1L;
			b = 1L;
			return b;
		} else {
			x = a + b;
			a = b;
			b = x;
		}

		return x;
	}
}