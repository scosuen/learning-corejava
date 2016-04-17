package com.scott.multi_thread.wait_notify;

public class WaitNotifyTest {

	public static void main(String[] args) throws InterruptedException {
		
		class Count {
			private int count;
			public int getCount() {
				return count;
			}
			public void addCount() {
				count++;
			}
		}
		
		
		Count count = new Count();
		
		Thread t1 = new Thread() {
			public void run() {
				synchronized (count) {
					System.out.println("T1 start");
					while (count.getCount() <= 3) {
						try {
							count.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("Tread 1 count is 1.");
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				synchronized (count) {
					System.out.println("T2 start count=" + count.getCount());
					while (count.getCount() <= 3) {
						count.addCount();
					}
					
					count.notify();
					System.out.println("T2 end count=" + count.getCount());
				}
			}
		};

		t1.start();
		Thread.sleep(100);
		t2.start();
	}

}
