package com.grm.demo3;

/*
THIS IN IMPLEMENTING USING RUNNABLE INTERFACE.. 
*/

class ThreadA implements Runnable {
	@Override
	public void run() {
		for (int i = 20; i < 40; i++) {
			System.out.println("inside run() of ThreadA" + i);
		}
	}

	public static void main(String[] args) {
		
		ThreadA t1 = new ThreadA();
		Thread t = new Thread(t1); // passing Runnable object to the constructor of Thread class
		t.start();
		for (int i = 20; i < 40; i++) {
			System.out.println("inside main of ThreadA:" + i);
		}
	}
}