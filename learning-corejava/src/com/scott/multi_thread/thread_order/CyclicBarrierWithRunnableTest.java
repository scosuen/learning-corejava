package com.scott.multi_thread.thread_order;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierWithRunnableTest {
	public static void main(String[] args) {
		int N = 4;
		CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnalbe starts " + Thread.currentThread().getName());
			}
		});

		for (int i = 0; i < N; i++)
			new CyclicBarrierWriter(barrier).start();
	}

}
