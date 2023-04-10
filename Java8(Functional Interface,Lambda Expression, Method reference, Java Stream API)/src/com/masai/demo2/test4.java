package com.masai.demo2;

@FunctionalInterface
interface SayHello{
	void hello(String n);
}

public class test4 {
	
	// Here we are returning LE as an result..
	public static SayHello fun1() {
		return n -> System.out.println("Welcome "+n);
	}

	public static void main(String[] args) {
		
		SayHello h =fun1();
		
		h.hello("raghu");
	}
}
