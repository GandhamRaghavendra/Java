package com.masai.demo3;

// Method Reference..!
//2.Reference to an instance (non-static) method:

interface Intr2{
	void printNumber(int n);
}

public class test3 {
	
	public void fun(int n) {
		System.out.println("Inside fun() non-static method");
		System.out.println(n);
	}

	public static void main(String[] args) {
        // creating object test3 class..!
		test3 test = new test3();
		
		// Here we are referring non-static method of test3 class..!
		Intr2 i1 = test :: fun;
		
		i1.printNumber(100);
		
		Intr2 i2 = System.out::print;
		
		i2.printNumber(200);
	}
}
