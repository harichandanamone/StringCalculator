package com.example.StringCalculator;

public class StringCalculator {
	
	public static int Add(String input) {
		int sum=0;
		if(input.isEmpty())
			return 0;
			
		else if(input.contains(",")) {
			String[] numbers = input.split(",|\n");
			for(String num : numbers) {
				sum += Integer.parseInt(num);
			}
			return sum;
			
		}
		else {
			return Integer.parseInt(input);
		}
	}
	
	

}
