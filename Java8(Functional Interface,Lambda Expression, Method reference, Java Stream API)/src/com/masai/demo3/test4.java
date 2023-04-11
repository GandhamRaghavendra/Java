package com.masai.demo3;

// Method Reference..!

//3.Reference to a constructor:

interface Intr3{
	void sayHello();
}
public class test4 {
	
	public test4() {
		System.out.println("Method Reference using Constructor..!");
		System.out.println("Hello..");
	}
	
	public static void main(String[] args) {
		
		Intr3 i1 = test4 :: new;
		
		i1.sayHello();
	}
}
