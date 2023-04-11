package com.masai.demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.masai.demo2.Student;

//Some of the new functional interfaces introduced in java 8 to perform functional style of 
//programming. these interfaces belongs to java.util.function package.

//1. Predicate<T>
//2. Consumer<T>
//3. Supplier<T>
//4. Function<T,R>



//1. Predicate<T>
// This interface having one method..!

// ** public boolean test(T t) **;

// This method check weather the given object is satisfying the condition or not and return a boolean value..

// NOTE :- In java8 Collections frameWork is having a method removeIf() which uses Predicate ..!

public class test1 {

	public static void main(String[] args) {
		
		Predicate<Integer> pre = i -> i > 0;
		
		System.out.println(pre.test(20));// true
		
		System.out.println(pre.test(-20));// false
		
		System.out.println("*********************");
		
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1,"Raghu", 300));
		list.add(new Student(2,"Dipu", 400));
		list.add(new Student(2,"Chiru", 500));
		list.add(new Student(1,"Ritesh", 600));
		
		System.out.println(list);
		
		// This method uses Predicate..! 
		list.removeIf(s -> s.getMarks() < 500);
		
		System.out.println(list);
	}
}



