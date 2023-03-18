package com.grm.demo2;

class Common {
	public void fun1(String name) {
		System.out.print("Welcome");
		try {
			Thread.sleep(1000);
		} catch (Exception ee) {
		}
		System.out.println(name);
	}
}

class ThreadA extends Thread {
	Common c;
	String name;

	public ThreadA(Common c, String name) {
		this.c = c;
		this.name = name;
	}

	@Override
	public void run() {
		c.fun1(name);
	}
}

class ThreadB extends Thread {
	Common c;
	String name;

	public ThreadB(Common c, String name) {
		this.c = c;
		this.name = name;
	}

	@Override
	public void run() {
		c.fun1(name);
	}
}

class Main {
	public static void main(String[] args) {
		Common c1 = new Common();
		Common c2 = new Common();

		// sharing two different Common object to two different threads..

		ThreadA t1 = new ThreadA(c1, "Ram");
		ThreadB t2 = new ThreadB(c2, "Shyam");

		// Here also we will get unexpected output even though threads are acting on two
		// diff objects..
		
		// Because both threads t1 and t2 having object level locks

		// (*) But if we mark the synchronized fun1() method of class Common as "static"
		//     then we will get the regular output irrespective of multiple objects also.

		t1.start();
		t2.start();
	}
}
