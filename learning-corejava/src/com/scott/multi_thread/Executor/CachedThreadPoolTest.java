package com.scott.multi_thread.Executor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolTest {
	public static void main(String[] args){   
        ExecutorService executorService = Executors.newCachedThreadPool();   
//      ExecutorService executorService = Executors.newFixedThreadPool(5);  
//      ExecutorService executorService = Executors.newSingleThreadExecutor();  
        for (int i = 0; i < 20; i++){   
            executorService.execute(() -> {
            	
            	try {
            		int sec = new Random().nextInt(10);
					TimeUnit.SECONDS.sleep(sec);
					System.out.println(Thread.currentThread().getName() + " is running... sec: " + sec); 
				} catch (Exception e) {
					e.printStackTrace();
				}
            });   
        }   
        executorService.shutdown();   
    }   
}
