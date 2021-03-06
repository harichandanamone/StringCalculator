package com.example.StringCalculator;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {
	
	private String delimiter;
	private String numbers;
	
	
	private StringCalculator(String delimiter, String numbers) {
		
		this.delimiter = delimiter;
		this.numbers = numbers;
	}

	
	private int sum( ) {
		ensureNoNegativeNumbers();
		return getNumber()
				.sum();
	}


	private void ensureNoNegativeNumbers() {
		String negativeNumberArray = getNumber().filter(n->n<0).mapToObj(Integer::toString).collect(Collectors.joining(","));
		if(!negativeNumberArray.isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed : "+negativeNumberArray);
		}
	}

	private IntStream getNumber() {
		if(numbers.isEmpty()) {
			return IntStream.empty();
		}
		else {
			return Arrays.stream(numbers.split(delimiter))
					.mapToInt(Integer::parseInt);
		}
		
	}


	public static int Add(String input) {
		return parseInput(input).sum();	
	}


	

	private static StringCalculator parseInput(String input) {
		if(input.startsWith("//")) {
			String[] arr = input.split("\n");
			return new StringCalculator(arr[0].substring(2),arr[1]);
		}
		else {
			return  new StringCalculator(",|\n",input);
		}
		
	}
	
	

}
