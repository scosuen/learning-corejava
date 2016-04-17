package com.scott.multi_thread.thread_order;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		int N = 4;
		CyclicBarrier barrier = new CyclicBarrier(N);
		for (int i = 0; i < N; i++)
			new CyclicBarrierWriter(barrier).start();
	}
}
