package com.scott.multi_thread.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolTest {
	public static void main(String[] args){   
        ExecutorService executorService = Executors.newCachedThreadPool();   
//      ExecutorService executorService = Executors.newFixedThreadPool(5);  
//      ExecutorService executorService = Executors.newSingleThreadExecutor();  
        for (int i = 0; i < 5; i++){   
            executorService.execute(() -> {
            	System.out.println(Thread.currentThread().getName() + "线程被调用了。");   
            	
            });   
            System.out.println("*************" + i + " *************");   
        }   
        executorService.shutdown();   
    }   
}
