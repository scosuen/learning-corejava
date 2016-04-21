package com.scott.multi_thread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class RecursiveActionTest {
	public static void main(String[] args) throws InterruptedException {
		ForkJoinPool pool = new ForkJoinPool();
		// 提交可分解的任务
		pool.submit(new PrintTask(0, 101));

		// 阻塞等待所有任务完成
		pool.awaitTermination(2, TimeUnit.SECONDS);
		pool.shutdown();// 关闭线程池
	}
}

class PrintTask extends RecursiveAction {
	// 每个小任务，最多只打印50个数
	private static final int threshold = 50;
	// 打印任务的开始
	private int start;
	// 打印任务的结束
	private int end;

	public PrintTask() {
		// TODO Auto-generated constructor stub
	}

	// 打印从start到end之间的任务
	public PrintTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {

		if (end - start < threshold) {
			for (int i = start; i < end; i++) {

				System.out.println(Thread.currentThread().getName() + "i的值:" + i);
			}
		} else {
			// 当end与start之间的差大于threshold，及打印的数超过50个时，
			// 将大任务分解成2个小任务
			int middle = (start + end) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			// 并行执行两个小任务
			left.fork();
			right.fork();
		}
	}
}
