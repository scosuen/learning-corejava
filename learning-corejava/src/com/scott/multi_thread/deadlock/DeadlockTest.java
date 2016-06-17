package com.scott.multi_thread.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadlockTest {

	private String resourceA = "Resource A";
	private String resourceB = "Resource B";

	private Object lock = new Object();

	public static void main(String[] args) {
		DeadlockTest deadlockTest = new DeadlockTest();

		// deadlockTest.test1();

		// deadlockTest.test2();
		deadlockTest.test3();
	}

	public void test2() {
		System.out.println("test 2");

		ExecutorService es = Executors.newCachedThreadPool();

		es.submit(() -> {
			synchronized (lock) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(resourceA);
				System.out.println(resourceB);
			}
		});

		es.submit(() -> {
			synchronized (lock) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(resourceB);
				System.out.println(resourceA);
			}
		});
	}

	public void test1() {
		System.out.println("test 1");

		ExecutorService es = Executors.newCachedThreadPool();

		es.submit(() -> {
			synchronized (resourceA) {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (resourceB) {
					System.out.println(resourceA);
					System.out.println(resourceB);
				}
			}
		});

		es.submit(() -> {
			synchronized (resourceB) {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (resourceA) {
					System.out.println(resourceA);
					System.out.println(resourceB);
				}
			}
		});
	}

	public void test3() {
		ThreadLocal<String> tlA = ThreadLocal.<String> withInitial(() -> {
			return resourceA;
		});

		ThreadLocal<String> tlB = new ThreadLocal<String>(){
			protected String initialValue() {
				return resourceB;
			}
		};
		
		new Thread(() -> {
			System.out.println("Thread A: " + tlA.get());
			tlA.set("resource A modified by Thread A");
			System.out.println("Thread A: " + tlA.get());
		}).start();

		new Thread(() -> {
			System.out.println("Thread B: " + tlA.get());
			tlA.set("resource A modified by Thread A");
			System.out.println("Thread B: " + tlA.get());
		}).start();
	}
}
