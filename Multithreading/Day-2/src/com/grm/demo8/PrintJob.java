package com.grm.demo8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable {
	String name;

	PrintJob(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println(name + " job started by Thread :" + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + "..job completed by Thread :" + Thread.currentThread().getName());
	}
}

class Main {
	public static void main(String[] args) {
		PrintJob[] jobs = { new PrintJob("Ram"), new PrintJob("Ravi"), new PrintJob("Anil"), new PrintJob("Shiva"),
				new PrintJob("Pawan"), new PrintJob("Suresh") };
		
		ExecutorService service = Executors.newFixedThreadPool(3);// Created pool of three threads..
		
		for (PrintJob job : jobs) {
			service.submit(job);
		}
		service.shutdown();// to shutdown the executorService.
	}
}

/*
*************Start*****************

	How can we improve the use of Threads ,as a resources ? 
	
	By creating pools of ready to use threads ,and using them.
	
	Creating a new thread for every task may creates performance and memory problems, to overcome this we 
	should go for Thread pool.
	
	Thread pool is a pool of already created threads ready to do our tasks.
	
	Thread pool framework is  also known as executor framework. this concept is introduced in java5.
	
	Thread pool related API comes in the form of java.util.concurrent package.
	
	Without Thread pool, if we have 10 different independent tasks are there then we need to create 10 separate 
	threads.
	
	But using Thread pool concept ,we create a Thread pool of 5 threads and submit all the 10 tasks to this Thread 
	pool.
	
	Here a single thread can perform multiple independent tasks. so that performance will be improved.

*************End*******************
*/