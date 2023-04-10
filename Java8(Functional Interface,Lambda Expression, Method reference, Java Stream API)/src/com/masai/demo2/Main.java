package com.masai.demo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Student> list =  new ArrayList<>();
		
		
		list.add(new Student(1,"raghu", 250));
		list.add(new Student(2,"muna", 300));
		list.add(new Student(3,"dipu", 350));
		
		Collections.sort(list,(s1,s2) -> s1.getMarks() < s2.getMarks() ? 1 : -1);
		
		System.out.println(list);
	}

}
