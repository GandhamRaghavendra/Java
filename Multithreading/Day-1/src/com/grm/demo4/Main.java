package com.grm.demo4;

// RUNNING TWO DIFF THREADS ON TWO DIFF OBJECTS..

class ThreadA implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			String tname = Thread.currentThread().getName();// Here we are Getting the name provided
			System.out.println(tname + " is running ");
		}
	}
}

class ThreadB implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			String tname = Thread.currentThread().getName();// Here we are Getting the name provided
			System.out.println(tname + " is running ");
		}
	}
}

public class Main {
	public static void main(String[] args) {

		ThreadA ta = new ThreadA();// Creating Obj of Runnable class..
		Thread t1 = new Thread(ta);// Passing Runnable object to Thread for Execution..

//Skip		ThreadB tb = new ThreadB();// Creating Obj of Runnable class..

		Thread t2 = new Thread(new ThreadB());// we can write like this also..

		t1.setName("raghu");// Setting name of the Thread..
		t2.setName("dipu");// Setting name of the Thread..

		t1.start();
		t2.start();
	}
}