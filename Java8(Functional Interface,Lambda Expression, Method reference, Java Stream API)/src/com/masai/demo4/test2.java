package com.masai.demo4;

import java.util.function.Consumer;

import com.masai.demo2.Student;

// 2.Consumer<T t>;

// public void accept(T t);

// This method consumes the give object but don't return anything..!

// NOTE :- In collection frameWork forEach() work like Consumer Interface..!

public class test2 {

	public static void main(String[] args) {
	
		Consumer<Student> c = s -> {
			System.out.println("Roll is "+s.getRoll());
			System.out.println("Name is "+s.getName());
			System.out.println("Marks is "+s.getMarks()); 
			};
			
			c.accept(new Student(10,"Raghu",850));
	}
}
