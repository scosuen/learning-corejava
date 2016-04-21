package com.scott.multi_thread.Executor;

import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletionServiceTest {

	public void run() {
		ExecutorService pool = Executors.newFixedThreadPool(10);
		CompletionService<String> completionServcie = new ExecutorCompletionService<String>(pool);
		try {
			for (int i = 0; i < 10; i++) {
				completionServcie.submit(() -> {
					Thread.sleep(new Random().nextInt(5000));
					return Thread.currentThread().getName();
				});
			}
			for (int j = 0; j < 10; j++) {
				// take �����ȴ���һ����������� Future ����
				// poll ���ȴ����н���ͷ���һ�� Future ���󣬷��򷵻� null��
				System.out.println(completionServcie.take().get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			pool.shutdown();
		}
	}

	public static void main(String[] args) {
		new CompletionServiceTest().run();
	}
}
