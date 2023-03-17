package com.grm.demo1;

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
		Common c = new Common();

		// sharing same Common object to two thread
		ThreadA t1 = new ThreadA(c, "Ram");
		ThreadB t2 = new ThreadB(c, "Shyam");

		// Here two threads are accessing same fun1() same time so we will get output
		// like "WelcomeWelcome RamShyam"
		
		// BUT IF WE ARE MAKING THE fun() SYNCHRONIZED THEN MULTIPLE THREAD CAN'T ACCESS
		// fun() SAME TIME AND WE WILL GET PROPER OUTPUT
		t1.start();
		t2.start();
	}
}
