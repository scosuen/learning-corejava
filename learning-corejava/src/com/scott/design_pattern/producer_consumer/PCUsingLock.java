package com.scott.design_pattern.producer_consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * In JDK 5, the performance of Lock is better than synchronized.
 * 
 * @author Ying
 *
 */
public class PCUsingLock {

	private List<Integer> queue = new LinkedList<Integer>();

	private class Producer extends Thread {
		private Lock lock = null;
		private Condition condition = null;

		public Producer(Lock lock, Condition condition) {
			this.lock = lock;
			this.condition = condition;
		}

		@Override
		public void run() {
			timerTick();
		}

		private void timerTick() {
			// if we don't consider the max number of queue
			try {
				lock.lock();
				queue.add(new Random().nextInt(10));
				condition.signalAll();
			} finally {
				lock.unlock();
			}
		}
	}

	private class Consumer extends Thread {
		private Lock lock = null;
		private Condition condition = null;

		public Consumer(Lock lock, Condition condition) {
			this.lock = lock;
			this.condition = condition;
		}

		@Override
		public void run() {
			try {
				consumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private void consumer() throws InterruptedException {
			Integer el;
			while (true) {
				try {
					lock.lock();
					while (queue.size() <= 0) {
						condition.await();
					}
					el = queue.remove(0);
				} finally {
					lock.unlock();
				}
				processElement(el);
			}
		}

		private void processElement(Integer el) {
			System.out.println(el);
		}
	}

	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		final Condition condition = lock.newCondition();
		PCUsingLock pc = new PCUsingLock();
		ExecutorService executorService = Executors.newCachedThreadPool();

		executorService.submit(pc.new Consumer(lock, condition));

		for (int i = 0; i < 10; i++) {
			executorService.submit(pc.new Producer(lock, condition));
		}

		executorService.shutdown();
	}
}
