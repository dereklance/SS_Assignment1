/**
 * 
 */
package com.ss.asgn5.Lambdas2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 * @author dlance
 *
 */
class LambdasPart2Test {
	static final List<Function<Integer, String>> operations = List.of(
			LambdasPart2.isOdd(),
			LambdasPart2.isPrime(),
			LambdasPart2.isPalindrome()
	);

	/**
	 * Test method for {@link com.ss.asgn5.Lambdas2.LambdasPart2#isOdd()}.
	 */
	@Test
	void testIsOdd() {
		var isOdd = LambdasPart2.isOdd();
		
		assertEquals("ODD", isOdd.apply(3));
		assertEquals("EVEN", isOdd.apply(4));
	}

	/**
	 * Test method for {@link com.ss.asgn5.Lambdas2.LambdasPart2#isPrime()}.
	 */
	@Test
	void testIsPrime() {
		var isPrime = LambdasPart2.isPrime();
		
		assertEquals("PRIME", isPrime.apply(3));
		assertEquals("PRIME", isPrime.apply(2));
		assertEquals("PRIME", isPrime.apply(29));
		assertEquals("COMPOSITE", isPrime.apply(4));
	}

	/**
	 * Test method for {@link com.ss.asgn5.Lambdas2.LambdasPart2#isPalindrome()}.
	 */
	@Test
	void testIsPalindrome() {
		var isPalindrome = LambdasPart2.isPalindrome();
		
		assertEquals("PALINDROME", isPalindrome.apply(9));
		assertEquals("NOT PALINDROME", isPalindrome.apply(14));
		
		assertEquals("PALINDROME", isPalindrome.apply(11));
		assertEquals("NOT PALINDROME", isPalindrome.apply(122));
	}
	
	@Test
	void runTestSuite() {
		try {
			List<String> inputLines = Files.readAllLines(Paths.get("input.txt"));
			inputLines.remove(0);
			List<String> outputLines = Files.readAllLines(Paths.get("output.txt"));

			IntStream.range(0, inputLines.size()).forEach((index) -> {
				String[] testCase = inputLines.get(index).split(" ");
				Integer condition = Integer.parseInt(testCase[0]) - 1;
				Integer number = Integer.parseInt(testCase[1]);
				String expectedOutput = outputLines.get(index);
				
				String actualOutput = operations.get(condition).apply(number);
				assertEquals(expectedOutput, actualOutput);
				
			});
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

}
