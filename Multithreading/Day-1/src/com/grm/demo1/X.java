package com.grm.demo1;

public class X extends Thread{

	
	@Override
	public void run() {
		for(int i=0;i<30;i++) {
			System.out.println("Inside run method"+i);
		}
		System.out.println("run() Ended");
	}
	
	public static void main(String[] args) {
	  
		// -- default main thread is running.
		
		X x = new X();
		//x.run(); It will execute as normal method;
		x.start();// It will execute as separate thread.
		
		for(int i=0;i<30;i++) {
			System.out.println("Inside main method"+i);
		}
		System.out.println("main() Ended");
	}
}
