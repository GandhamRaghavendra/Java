package com.grm.demo6;

class Main extends Thread {
	public void run() {
		System.out.println("Inside run method");
	}

	public static void main(String[] args) {
		Main t1 = new Main();
		Main t2 = new Main();
		Main t3 = new Main();
		
		// Priority Before Setting
		System.out.println("t1 thread priority : " + t1.getPriority());//5
		System.out.println("t2 thread priority : " + t2.getPriority());//5
		System.out.println("t3 thread priority : " + t3.getPriority());//5
		
		t1.setPriority(2);
		t2.setPriority(5);
		t3.setPriority(8);
		
// t3.setPriority(21); will throw IllegalArgumentException
		
		// Priority After Setting
		System.out.println("t1 thread priority : " + t1.getPriority());
		System.out.println("t2 thread priority : " + t2.getPriority());
		System.out.println("t3 thread priority : " + t3.getPriority());
		
		System.out.println("Currently Executing Thread : " + Thread.currentThread().getName());//main
		System.out.println("Main thread priority : " + Thread.currentThread().getPriority());//5
		
		Thread.currentThread().setPriority(10);
		System.out.println("Main thread priority : " + Thread.currentThread().getPriority());//10
	}
}