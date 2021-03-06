package com.example.StringCalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {
	
	public static int Add(String input) {
		if(input.isEmpty())
			return 0;
		String delimiter = ",|\n";
		
		if(input.startsWith("//")) {
			String[] arr = input.split("\n");
			delimiter = arr[0].substring(2);
			input = arr[1];
		}
		
		Stream<String> numbers = Arrays.stream(input.split(delimiter));
		return numbers.mapToInt(Integer::parseInt).sum();	
		
		
	}
	
	

}
