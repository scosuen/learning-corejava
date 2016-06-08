package com.scott.design_pattern.observer;

public class MyButtonTest {
	
	public static void main(String[] args) {
		MyButtonListener myButtonListener = new MyButtonListener();
		
		MyButton myButton = new MyButton(myButtonListener);
		
		myButton.click();
		myButton.click();
	}

}
