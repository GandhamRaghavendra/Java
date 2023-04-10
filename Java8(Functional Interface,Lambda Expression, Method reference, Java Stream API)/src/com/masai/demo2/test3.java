package com.masai.demo2;

// FI with 0 argument method;
@FunctionalInterface
interface Hello {
	void sayHello();
}

// FI with multiple argument method..!
@FunctionalInterface
interface Calculator {
	int calculate(int a, int b);
}

// FI with 1 argument method..!
@FunctionalInterface
interface Print {
	void print(String str);
}

//Let’s implement on functional interface using Lambda Expression:

public class test3 {

	public static void main(String[] args) {

//		In case of zero or more than one parameter the () small bracket is mandatory..

		Hello i1 = () -> {
			System.out.println("Welcome User");
		};
		
		i1.sayHello();

//		Note: in the argument list, mentioning data type is optional. and in case of single  parameter the () small 
//		bracket is also optional.

		Print i2 = (name) -> {
			System.out.println("Welcome " + name);
		};
		
	    i2.print("Raghu");

		// we can omit the () small bracket also
		Print i3 = n -> {
			System.out.println("Welcome " + n);
		};
		
		i3.print("dipu");
		
//		Lamda Expression using multiple parameters..!
		
		// * Here we are passing LE as an argument to a method..!

		Calculator add = (a, b) -> a + b;

		Calculator subtract = (a, b) -> a - b;

		System.out.println(add.calculate(5, 10));

		System.out.println(subtract.calculate(10, 5));
	}
}
