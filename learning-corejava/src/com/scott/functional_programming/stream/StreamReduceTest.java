package com.scott.functional_programming.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamReduceTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(Integer.valueOf(i));
		}

		System.out.println(list.stream().reduce((result, element) -> result = result + element));

		System.out.println(list.stream().reduce(0, (result, element) -> result = result + element));

		System.out.println(list.stream().reduce(0, (result, element) -> result = result + element, (u, t) -> t));

	}

}
