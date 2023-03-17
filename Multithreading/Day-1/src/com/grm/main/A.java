package com.grm.main;
/*
We implement threads either of the following two ways: 
1. By implementing Runnable Interface
2. By extending Thread class 
*/


 class A extends Thread{

	@Override
	public void run() {
		
	}
}
/*
Thread class is also implements Runnable interface internally..
*/
 

 class B implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
