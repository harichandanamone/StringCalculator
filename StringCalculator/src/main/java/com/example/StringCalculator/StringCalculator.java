package com.example.StringCalculator;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {
	
	private String delimiter;
	private String numbers;
	private static int COUNTFORADDMETHOD;
	
	
	private StringCalculator(String delimiter, String numbers) {
		
		this.delimiter = delimiter;
		this.numbers = numbers;
	}

	
	private int sum( ) {
		ensureNoNegativeNumbers();
		return getNumber()
				.sum();
	}
	
	
	public static int GetCalledCount() {
		return COUNTFORADDMETHOD;
		
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
					.mapToInt(Integer::parseInt)
					.map(n->n%1000);
		}
		
	}


	public static int Add(String input) {
		COUNTFORADDMETHOD ++;
		return parseInput(input).sum();	
	}


	

	private static StringCalculator parseInput(String input) {
		if(input.startsWith("//")) {
			String[] arr = input.split("\n");
			return new StringCalculator(parseHeader(arr[0]),arr[1]);
		}
		else {
			return  new StringCalculator(",|\n",input);
		}
		
	}


	private static String parseHeader(String Header) {
		String delimiter = Header.substring(2);
		if(delimiter.startsWith("[")) {
			 delimiter = delimiter.substring(1,delimiter.length()-1);
			 return Stream.of(delimiter.split("]\\[")).map(Pattern::quote).collect(Collectors.joining("|"));
			
		}
			return Pattern.quote(delimiter);
		
		
	}
	
	

}
