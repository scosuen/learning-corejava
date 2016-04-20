package com.scott.functional_programming.function_package;

import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		Supplier ultimateAnswerSupplier = new Supplier() {
			@Override
			public Integer get() {
				// Long time computation
				return 42;
			}
		};
		
		Integer ultimateAnswer = (Integer) ultimateAnswerSupplier.get();
		System.out.println(ultimateAnswer);
	}
}
