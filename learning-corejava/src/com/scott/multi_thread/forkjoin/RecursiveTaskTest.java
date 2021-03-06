package com.scott.multi_thread.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskTest {
	public static void main(String[] args) throws Exception {

		int[] arr = new int[1100];
		Random rand = new Random();
		int total = 0;
		// 初始化100个数字
		for (int i = 0; i < arr.length; i++) {
			int tmp = rand.nextInt(20);
			// 对元素赋值，并将数组元素的值添加到total总和中
			total += (arr[i] = tmp);

		}
		System.out.println("正确的total:" + total);
		ForkJoinPool pool = new ForkJoinPool();
		// 提交可分解的CalTask任务
		Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
		System.out.println(future.get());
		// 关闭线程池

		pool.shutdown();
	}

}

class CalTask extends RecursiveTask<Integer> {

	// 将每个小任务，最多只能累加20个数
	private static final int threshold = 20;
	private int arr[];
	private int start;// 开始
	private int end;//
	// 累加从start到end之间的数

	public CalTask() {
		// TODO Auto-generated constructor stub
	}

	// 累加从start到end的数组元素
	public CalTask(int[] arr, int start, int end) {
		super();
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// 当end与start之间的差小于threshold，开始进行累加
		if (end - start < threshold) {
			for (int i = start; i < end; i++) {
				sum += arr[i];
			}
			return sum;

		} else {

			// 当end与start之间的差大于threshold，要计算的数超过20个时，
			// 将大任务分解成两个小任务

			int middle = (start + end) / 2;
			CalTask left = new CalTask(arr, start, middle);
			CalTask right = new CalTask(arr, middle, end);
			// 并行执行2个小任务
			left.fork();
			right.fork();
			// 把2个小任务，累加的结果合并起来
			return left.join() + right.join();
		}

	}

}
