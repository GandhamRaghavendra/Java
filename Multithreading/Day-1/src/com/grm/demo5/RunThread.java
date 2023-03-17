package com.grm.demo5;

// RUNNING TWO THREADS ON SINGLE OBJECT..

public class RunThread implements Runnable {
	public void run() {
		for (int i = 0; i < 25; i++) {
			String tname = Thread.currentThread().getName();// GETTING NAME OF THE THREAD PROVIDED BELOW..
			System.out.println(tname + ": is running");
		}
	}

	public static void main(String[] args) {
		RunThread job = new RunThread();
		
		Thread one = new Thread(job);
		Thread two = new Thread(job);
		
		one.setName("Dhoni thread..");
		two.setName("Kohli thread..");
		
		one.start();
		two.start();
	}
}