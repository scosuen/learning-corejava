package com.scott.multi_thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
	private static AtomicIntegerFieldUpdater<User> userAgeupdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

	public static void main(String[] args) {
		User conan = new User("conan", 10);
		System.out.println("user age : " + conan.getAge());
		System.out.println(userAgeupdater.getAndIncrement(conan));
		System.out.println("user age : " + conan.getAge());
		System.out.println(userAgeupdater.get(conan));
	}

	public static class User {
		private String name;
		public volatile int age;

		public User(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}
	}
}
