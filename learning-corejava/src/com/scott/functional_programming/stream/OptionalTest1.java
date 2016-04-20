package com.scott.functional_programming.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalTest1 {
	private static String result = null;

	public static void main(String[] args) {
		Stream<String> names = Stream.of("Lamurudu", "Okanbi", "Oduduwa");
		Optional<String> longest = names.filter(name -> name.startsWith("W")).findFirst();

		longest.ifPresent(name -> {
			result = name.toUpperCase();

		});

		result = longest.orElse("Nimrod");
		System.out.println("The longest name is " + result);

		result = longest.orElseGet(() -> {
			// perform some interesting code operation
			// then return the alternate value.
			return "Nimrod";
		});

		Optional<String> lNameInCaps = longest.map(String::toUpperCase);
		// System.out.println(lNameInCaps.get());
	}

}
