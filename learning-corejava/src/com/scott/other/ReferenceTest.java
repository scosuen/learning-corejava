package com.scott.other;

public class ReferenceTest {

	public static void main(String[] args) {
		// stringTest1();
//		userTest1();
		balloonTest1();
	}

	public static void stringTest1() {
		String string = "a";
		stringTest2(string);

		System.out.println("stringTest1 string: " + string);
	}

	public static void stringTest2(String str) {
		System.out.println("stringTest2 str: " + str);
		str = "b";
		System.out.println("stringTest2 str: " + str);
	}

	public static void userTest1() {
		User user = new User();
		user.setUsername("ying");
		userTest2(user);

		System.out.println("userTest1 user: " + user);

		// userTest3(user);

		System.out.println("userTest1 user: " + user);
	}

	public static void userTest2(User user) {
		System.out.println("userTest2 user: " + user);
		user.setUsername("ying1");
		System.out.println("userTest2 user: " + user);
	}

	public static void userTest3(User user) {
		System.out.println("userTest3 user: " + user);
		User user3 = user;
		user3.setUsername("ying3");
		System.out.println("userTest3 user: " + user);
		System.out.println("userTest3 user3: " + user);
	}

	public static void balloonTest1() {
		Balloon red = new Balloon("Red"); // memory reference 50
		Balloon blue = new Balloon("Blue"); // memory reference 100

		swap(red, blue);
		System.out.println("red color=" + red.getColor());
		System.out.println("blue color=" + blue.getColor());

		foo(blue);
		System.out.println("blue color=" + blue.getColor());
	}

	private static void foo(Balloon balloon) { // baloon=100
		balloon.setColor("Red"); // baloon=100
		balloon = new Balloon("Green"); // baloon=200
		balloon.setColor("Blue"); // baloon = 200
	}

	// Generic swap method
	public static void swap(Balloon red, Balloon blue) {
		Balloon temp = red;
		red = blue;
		blue = temp;
		
		System.out.println("swap red: " + red.getColor());
		System.out.println("swap blue: " + blue.getColor());
	}

}

class User {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return getUsername();
	}
}

class Balloon {

	private String color;

	public Balloon() {
	}

	public Balloon(String c) {
		this.color = c;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
