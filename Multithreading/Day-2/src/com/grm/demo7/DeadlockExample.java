package com.grm.demo7;

public class DeadlockExample {
	public static void main(String[] args) {
		// Two resources

		// 1 Two objects resource1 and resource2 are defined as the shared
		// resources...!!
		Object resource1 = new Object();
		Object resource2 = new Object();

		// Thread 1 locks resource 1 then waits for resource 2
		Thread thread1 = new Thread(() -> {
			synchronized (resource1) {
				System.out.println("Thread 1: Locked resource 1");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (resource2) {
					System.out.println("Thread 1: Locked resource 2");
				}
			}
		});

		// Thread 2 locks resource 2 then waits for resource 1
		Thread thread2 = new Thread(() -> {
			synchronized (resource2) {
				System.out.println("Thread 2: Locked resource 2");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (resource1) {
					System.out.println("Thread 2: Locked resource 1");
				}
			}
		});

		// Start both threads
		thread1.start();
		thread2.start();

		// Both threads are now waiting for the other thread to release its locked
		// resource, resulting in a deadlock.
	}
}
