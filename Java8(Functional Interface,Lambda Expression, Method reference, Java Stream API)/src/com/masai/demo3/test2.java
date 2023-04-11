package com.masai.demo3;

//Method Reference:

//1.Reference to a Static Method:

@FunctionalInterface
interface Intr1{
	int stringToNumber(String s);
}


public class test2 {
	public static int fun(String s) {
		System.out.println("Using static method reference..!");
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) {
		
		// Using static method reference..!
		Intr1 i1 = test2 :: fun;
		
		int stringToNumber = i1.stringToNumber("55");
		
		System.out.println(stringToNumber);
		
		// Using static method of Integer class..!
		Intr1 i2 = Integer :: parseInt;
		
		int stringToNumber2 = i2.stringToNumber("66");
		
		System.out.println(stringToNumber2);
		
		// Using Lamda Expression..!
		Intr1 i3 = (s -> Integer.parseInt(s));
		
		int stringToNumber3 = i3.stringToNumber("666");
		
		System.out.println(stringToNumber3);
	}

}
