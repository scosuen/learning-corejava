package com.scott.functional_programming.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class SteamTest {

	public static void main(String[] args) {
		Stream<Long> natural = Stream.generate(new NaturalSupplier());
		natural.map((x) -> {
			return x * x;
		}).limit(10).forEach(System.out::println);
	}

}

class NaturalSupplier implements Supplier<Long> {

	long value = 0;

	public Long get() {
		this.value = this.value + 1;
		return this.value;
	}
}