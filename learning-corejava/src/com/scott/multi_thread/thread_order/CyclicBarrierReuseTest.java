package com.scott.multi_thread.thread_order;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierReuseTest {
	public static void main(String[] args) {
		int N = 4;
		CyclicBarrier barrier = new CyclicBarrier(N);

		for (int i = 0; i < N; i++) {
			new CyclicBarrierWriter(barrier).start();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("CyclicBarrierÖØÓÃ");

		for (int i = 0; i < N; i++) {
			new CyclicBarrierWriter(barrier).start();
		}
	}
}
