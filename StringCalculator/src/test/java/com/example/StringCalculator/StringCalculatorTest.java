package com.example.StringCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
	
	
	
}
