package com.masai.demo5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class terminalMethods {

	// forEach(), collect(), reduce() ..!
	public static void main(String[] args) {
		
//		1. forEach(): This method is used to perform an action on each element in a stream.
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		// Here we are using method reference..
		numbers.stream().forEach(System.out::println);
		System.out.println("***********************");
		
//		2. reduce(): This method is used to perform a reduction operation on the elements in a stream.
		
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
		
		int sum = numbers2.stream().reduce(0, (a, b) -> a + b);
		
		System.out.println(sum);
		 System.out.println("***********************");
		
//		3. collect(): This method is used to accumulate the elements in a stream into a collection.
		
		List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
		
		List<Integer> collectedNumbers = numbers3.stream()
				                                          .filter(n -> n % 2 == 0)
				                                          .collect(Collectors.toList());
		
		System.out.println(collectedNumbers);
		 System.out.println("***********************");
	}
}
