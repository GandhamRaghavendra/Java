package com.masai.demo5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// map(), filter(), sorted() ..

public class IntermediateMethod {

	public static void main(String[] args) {

//		1. map(): This method is used to transform each element in a stream to another element using a given function.
		
		List<String> names = Arrays.asList("John", "Sarah", "Michael");
		
		// This will return list of Integers.
		List<Integer> nameLengths = names.stream()
				                                 .map(String::length)
				                                 .collect(Collectors.toList());
		
		System.out.println(nameLengths);
		
		
//		2. filter(): This method is used to select elements from a stream based on a given predicate.
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		List<Integer> evenNumbers = numbers.stream()
				                                   .filter(n -> n % 2 == 0)
				                                   .collect(Collectors.toList());
		
		System.out.println(evenNumbers);
		
//		3. sorted(): This method is used to sort the elements in a stream based on a given comparator.
		
		List<Integer> numbers2 = Arrays.asList(3, 2, 1, 4, 5);
		
		List<Integer> sortedNumbers = numbers2.stream()
				                                       .sorted()
				                                       .collect(Collectors.toList());
		
		System.out.println(sortedNumbers);

	}
}
