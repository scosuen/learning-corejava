package com.scott.functional_programming.stream;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciStream {

	public static void main(String[] args) {
		Stream<Long> fibonacci = Stream.generate(new FibonacciSupplier());
//		fibonacci.limit(10).forEach(System.out::println);
		
		List<Long> list = fibonacci.skip(20).limit(10).collect(Collectors.toList());
		System.out.println(list);
	}

}

class FibonacciSupplier implements Supplier<Long> {

	long a = 0;
	long b = 1;

	@Override
	public Long get() {
		long x = a + b;
		a = b;
		b = x;
		return a;
	}
}