package com.scott.multi_thread.Executor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorTest {
	
	public static void main(String[] args) {
		SingleThreadExecutorTest s = new SingleThreadExecutorTest();
		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		
		for (int i = 0; i < 10; i++) {
			pool.execute(() -> {
				int i2 = new Random().nextInt(100);
				System.out.println(Thread.currentThread().getName() + "is running ... i: " + i2);
			});
		}
		
		pool.shutdown();
	}

}
