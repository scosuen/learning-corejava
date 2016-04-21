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
		// ��ʼ��100������
		for (int i = 0; i < arr.length; i++) {
			int tmp = rand.nextInt(20);
			// ��Ԫ�ظ�ֵ����������Ԫ�ص�ֵ��ӵ�total�ܺ���
			total += (arr[i] = tmp);

		}
		System.out.println("��ȷ��total:" + total);
		ForkJoinPool pool = new ForkJoinPool();
		// �ύ�ɷֽ��CalTask����
		Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
		System.out.println(future.get());
		// �ر��̳߳�

		pool.shutdown();
	}

}

class CalTask extends RecursiveTask<Integer> {

	// ��ÿ��С�������ֻ���ۼ�20����
	private static final int threshold = 20;
	private int arr[];
	private int start;// ��ʼ
	private int end;//
	// �ۼӴ�start��end֮�����

	public CalTask() {
		// TODO Auto-generated constructor stub
	}

	// �ۼӴ�start��end������Ԫ��
	public CalTask(int[] arr, int start, int end) {
		super();
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// ��end��start֮��Ĳ�С��threshold����ʼ�����ۼ�
		if (end - start < threshold) {
			for (int i = start; i < end; i++) {
				sum += arr[i];
			}
			return sum;

		} else {

			// ��end��start֮��Ĳ����threshold��Ҫ�����������20��ʱ��
			// ��������ֽ������С����

			int middle = (start + end) / 2;
			CalTask left = new CalTask(arr, start, middle);
			CalTask right = new CalTask(arr, middle, end);
			// ����ִ��2��С����
			left.fork();
			right.fork();
			// ��2��С�����ۼӵĽ���ϲ�����
			return left.join() + right.join();
		}

	}

}
