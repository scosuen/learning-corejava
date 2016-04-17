package com.scott.multi_thread.wait_notify;

public class ThreadF {
	final static Object object = new Object();
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread() {
			public void run() {
				synchronized (object) {
					System.out.println("T1 start!");
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("T1 end!");
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				synchronized (object) {
					System.out.println("T2 start!");
					object.notify();
					System.out.println("T2 end!");
				}
			}
		};
		t1.start();
		Thread.sleep(100);
		t2.start();
	}

}
