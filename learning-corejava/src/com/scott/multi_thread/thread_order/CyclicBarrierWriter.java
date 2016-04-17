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
		System.out.println("�߳�" + Thread.currentThread().getName() + "����д������...");
		try {
			Thread.sleep(2000); // ��˯����ģ��д�����ݲ���
			System.out.println("�߳�" + Thread.currentThread().getName() + "д��������ϣ��ȴ������߳�д�����");

			cyclicBarrier.await();
			// ����ָ����ʱ�䷢�����̻߳�û�дﵽbarrier�����׳��쳣������ִ�к��������
			// cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "�����߳�д����ϣ�����������������...");
	}
}
