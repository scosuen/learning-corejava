package com.scott.design_pattern.observer;

import java.util.Observable;

public class MyButton extends Observable {
	
	private int count = 0;
	
	private MyButtonListener myButtonListener;
	
	public MyButton (MyButtonListener myButtonListener) {
		this.myButtonListener = myButtonListener;
		addObserver(myButtonListener);
	}
	
	public void click () {
		setChanged();
		notifyObservers(++count);
	}
	
	private void onDestroy() {
		deleteObserver(myButtonListener);
	}
}
