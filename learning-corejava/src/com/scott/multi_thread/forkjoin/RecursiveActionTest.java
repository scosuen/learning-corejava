package com.scott.multi_thread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class RecursiveActionTest {
	public static void main(String[] args) throws InterruptedException {
		ForkJoinPool pool = new ForkJoinPool();
		// �ύ�ɷֽ������
		pool.submit(new PrintTask(0, 101));

		// �����ȴ������������
		pool.awaitTermination(2, TimeUnit.SECONDS);
		pool.shutdown();// �ر��̳߳�
	}
}

class PrintTask extends RecursiveAction {
	// ÿ��С�������ֻ��ӡ50����
	private static final int threshold = 50;
	// ��ӡ����Ŀ�ʼ
	private int start;
	// ��ӡ����Ľ���
	private int end;

	public PrintTask() {
		// TODO Auto-generated constructor stub
	}

	// ��ӡ��start��end֮�������
	public PrintTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {

		if (end - start < threshold) {
			for (int i = start; i < end; i++) {

				System.out.println(Thread.currentThread().getName() + "i��ֵ:" + i);
			}
		} else {
			// ��end��start֮��Ĳ����threshold������ӡ��������50��ʱ��
			// ��������ֽ��2��С����
			int middle = (start + end) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			// ����ִ������С����
			left.fork();
			right.fork();
		}
	}
}
