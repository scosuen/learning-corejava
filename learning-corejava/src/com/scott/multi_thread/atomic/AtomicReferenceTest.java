package com.scott.multi_thread.atomic;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
	public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();

	public static void main(String[] args) {
		User user1 = new User("conan", 15);
		User user =  new User("conan", 15);
		atomicUserRef.set(user);
		System.out.println(atomicUserRef.get());

		User updateUser = new User("Shinichi", 17);
		atomicUserRef.compareAndSet(user1, updateUser);
		System.out.println(atomicUserRef.get());
		
		/////
		Set<User> userSet = new HashSet<User>();
		userSet.add(user);
		userSet.add(user1);
		System.out.println("user set : " + userSet);
	}
}

class User {
	private String name;
	private int age;

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

	@Override
	public String toString() {
		return "User Name: " + name + ", Age: " + age;
	}

	@Override
	public boolean equals(Object obj) {
		User otherUser = (User) obj;
		if (otherUser.getName().equals(getName()) && otherUser.getAge() == getAge())
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return getAge();
	}
}
