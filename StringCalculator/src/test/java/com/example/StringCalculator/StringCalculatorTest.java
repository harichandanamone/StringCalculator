package com.example.StringCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

	@Test
	public void AddEmptryString() {
		assertEquals(0,StringCalculator.Add(""));
	}
	
	@Test
	public void AddSingleNumber() {
		assertEquals(1,StringCalculator.Add("1"));
	}
	
	@Test
	public void sumsTwoNumbers() {
		assertEquals(3,StringCalculator.Add("1,2"));
	}
	
	@Test
	public void sumsMoreThanTwoNumbers() {
		assertEquals(5,StringCalculator.Add("1,2,2"));
	}
	
	@Test
	public void sumsNumbersSeperatedByNewLine() {
		assertEquals(6,StringCalculator.Add("1\n2,3"));
	}
	
	
	@Test 
	public void sumsNumbersBeginningWithDelimiter() {
		  assertEquals(3,StringCalculator.Add("//;\n1;2"));
	}
	
	
	@Rule
	public ExpectedException thrown  = ExpectedException.none();
	
	@Test
	public void throwsOnNegativeNumber() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("negatives not allowed : -3");
		 StringCalculator.Add("-3");
	}
	
	@Test
	public void thowsExceptionWithAllNegativeNumbersInMessage() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("negatives not allowed : -3,-2,-9");
		 StringCalculator.Add("-3,6,7,-2,-9");
		
	}
	 
	
	  
	  
	  
	 
	
	
	
}
