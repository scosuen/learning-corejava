package com.scott.multi_thread.Executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallbackThread {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorServicexecutorService = Executors.newFixedThreadPool(2);
		Callable c1 = new MyCallable("A");
		Callable c2 = new MyCallable("B");
		Future f1 = executorServicexecutorService.submit(c1);
		Future f2 = executorServicexecutorService.submit(c2);
		System.out.println(f1.get().toString());
		System.out.println(f2.get().toString());
		executorServicexecutorService.shutdown();
	}
}

class MyCallable implements Callable {
	private String oid;

	MyCallable(String oid) {
		this.oid = oid;
	}

	@Override
	public Object call() throws Exception {
		return oid + " 任务返回的内容";
	}
}
