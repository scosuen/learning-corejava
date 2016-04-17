package com.scott.design_pattern.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;

public class PCAchieveByBlockingQueue {

	private int queueSize = 10;
	private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

	public static void main(String[] args) {
		PCAchieveByBlockingQueue test = new PCAchieveByBlockingQueue();
		Producer producer = test.new Producer();
		Consumer consumer = test.new Consumer();

		producer.start();
		consumer.start();
	}

	class Consumer extends Thread {

		@Override
		public void run() {
			consume();
		}

		private void consume() {
			while (true) {
				try {
					queue.take();
					System.out.println("�Ӷ���ȡ��һ��Ԫ�أ�����ʣ��" + queue.size() + "��Ԫ��");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Producer extends Thread {

		@Override
		public void run() {
			produce();
		}

		private void produce() {
			while (true) {
				try {
					queue.put(1);
					System.out.println("�����ȡ�в���һ��Ԫ�أ�����ʣ��ռ䣺" + (queueSize - queue.size()));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
