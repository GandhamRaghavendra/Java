package com.masai.demo3;

//Method Reference:

// 1.Reference to a Static Method:


@FunctionalInterface
interface Intr {
	void sayHello(String name);
}

public class test1 {
	public static void fun1(String s) {
		System.out.println("Using static Method reference Welcome " + s);
	}

	public static void main(String[] args) {
//		ClassName::methodName
		Intr i1 = test1::fun1;
		i1.sayHello("Admin");
	}
}
