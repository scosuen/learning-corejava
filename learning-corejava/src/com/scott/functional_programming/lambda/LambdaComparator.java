package com.scott.functional_programming.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaComparator {

	public static void main(String[] args) {
		Employee e1 = new Employee("ying", 100);
		Employee e2 = new Employee("scott", 200);
		Employee e3 = new Employee("sun", 300);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e2);
		employees.add(e1);
		employees.add(e3);

		System.out.println("1: " + employees);

		employees.sort((Employee em1, Employee em2) -> {
			if (em1.getSalary() > em2.getSalary())
				return 1;
			if (em1.getSalary() < em2.getSalary())
				return -1;
			return 0;
		});

		System.out.println("2: " + employees);

		Comparator<Employee> bySalaryDesc = (Employee em1, Employee em2) -> {
			if (em1.getSalary() < em2.getSalary())
				return 1;
			if (em1.getSalary() > em2.getSalary())
				return -1;
			return 0;
		};
		
		employees.sort(bySalaryDesc);
		System.out.println("3: " + employees);
	}

}
