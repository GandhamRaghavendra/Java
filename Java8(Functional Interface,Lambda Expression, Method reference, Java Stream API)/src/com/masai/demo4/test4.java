package com.masai.demo4;

import java.util.function.Function;

import com.masai.demo2.Student;

//4. Function<T,R>

// public R apply(T t);

// This method takes one T type of object and return R type of object..!

public class test4 {

	public static void main(String[] args) {
		// Here we are taking one Integer obj and returning an Sting obj..!
		Function<Integer, String> f1 = (i) -> "This is a number"+i;
		
		System.out.println(f1.apply(10));
		
		// Here it takes Student and returning a string..!
		Function<Student,String> f2 = std -> "Hello "+std.getName()+" You got this "+std.getMarks()+" marks..!";
		
		System.out.println(f2.apply(new Student(1,"Raghu", 600)));
	}
}
