package com.scott.multi_thread.thread_order;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierWriter extends Thread {
	private CyclicBarrier cyclicBarrier;

	public CyclicBarrierWriter(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
		try {
			Thread.sleep(2000); // 以睡眠来模拟写入数据操作
			System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");

			cyclicBarrier.await();
			// 待了指定的时间发现有线程还没有达到barrier，就抛出异常并继续执行后面的任务。
			// cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "所有线程写入完毕，继续处理其他任务...");
	}
}
