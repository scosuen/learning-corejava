package com.scott.design_pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class MyButtonListener implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("button clicked :" + arg);
	}

}
