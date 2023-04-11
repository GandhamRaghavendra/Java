package com.masai.demo4;

import java.util.function.Supplier;

import com.masai.demo2.Student;

//3. Supplier<T t>;

// public T get();

// This method does't take anything but return T type of result..!

public class test3 {

	public static void main(String[] args) {
		
		Supplier<String> s = () -> "This is from Lambda Expression";
		System.out.println(s.get());
		
		Supplier<Student> s2 = () -> new Student(10, "Ram", 850);
		System.out.println(s2.get().getName());// Ram
		
		System.out.println(s2.get());// toStrign();
	}
}
