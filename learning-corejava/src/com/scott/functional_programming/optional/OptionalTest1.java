package com.scott.functional_programming.optional;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalTest1 {
	private static String result = null;

	public static void main(String[] args) {
		nullable();
	}
	
	public static void test1 () {
		Stream<String> names = Stream.of("Lamurudu", "Okanbi", "Oduduwa");
		Optional<String> longest = names.filter(name -> name.startsWith("W")).findFirst();

		longest.ifPresent(name -> {
			result = name.toUpperCase();
		});

		result = longest.orElse("Nimrod");
		
		result = longest.orElseGet(() -> {
			// perform some interesting code operation
			// then return the alternate value.
			return "Nimrod";
		});
		
		System.out.println("The longest name is " + result);

		Optional<String> lNameInCaps = longest.map(String::toUpperCase);
		// System.out.println(lNameInCaps.get());
	}
	
	public static void nullable () {
		Optional<String> n = Optional.ofNullable(null);
		
		Optional<String> n2 = Optional.of(null);
		
		System.out.println();
	}

}
