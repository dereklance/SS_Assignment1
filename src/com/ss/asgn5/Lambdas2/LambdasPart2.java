/**
 * 
 */
package com.ss.asgn5.Lambdas2;

import java.util.function.Function;

/**
 * @author dlance
 * Assignment 5, Part 2
 *
 */
public class LambdasPart2 {

	static Function<Integer, String> isOdd() {
		return num -> num % 2 == 1 ? "ODD" : "EVEN";
	}
	
	static Function<Integer, String> isPrime() {
		return num -> {
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					return "COMPOSITE";
				}
			}
			return "PRIME";
		};
	}
	
	static Function<Integer, String> isPalindrome() {
		return num -> {
			String number = String.valueOf(num);
			String reversed = new StringBuilder(number).reverse().toString();
			return number.equals(reversed) ? "PALINDROME" : "NOT PALINDROME";
		};
	}
}
