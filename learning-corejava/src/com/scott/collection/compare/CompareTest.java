package com.scott.collection.compare;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CompareTest {

	public static List<User> users = new ArrayList<User>() {
		{
			add(new User(2, "Ying", "sco@gmail.com", 50));
			add(new User(1, "Sun", "sun@gmail.com", 10));
			add(new User(3, "Kenny", "kenny@gamil.com", 20));
		}
	};

	public static void main(String[] args) {
//		test1();
		test2();
	}

	public static void test1() {
		System.out.println("users: " + users);
		
		Collections.sort(users);
		System.out.println("users: " + users);
	}
	
	public static void test2 () {
		System.out.println("users: " + users);
		Collections.sort(users);
		System.out.println("users: " + users);
		users.sort((User u1, User u2) -> {
			if (u1.getUserId() > u2.getUserId())
				return 1;
			else if (u1.getUserId() < u2.getUserId())
				return -1;
			else 
				return 0;
		});
		
		/*Collections.sort(users, (User u1, User u2) -> {
			if (u1.getUserId() > u2.getUserId())
				return 1;
			else if (u1.getUserId() < u2.getUserId())
				return -1;
			else 
				return 0;
		});*/
		
		System.out.println("users: " + users);
	}

}
