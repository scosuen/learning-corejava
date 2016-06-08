package com.scott.design_pattern.observer;

import java.util.Observable;

public class MyButton extends Observable {
	
	private int count = 0;
	
	public MyButton (MyButtonListener myButtonListener) {
		addObserver(myButtonListener);
	}
	
	public void click () {
		setChanged();
		notifyObservers(++count);
	}

}
