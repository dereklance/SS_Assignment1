/**
 * 
 */
package com.ss.asgn5.Lamdas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author dlance
 *
 */
class LambdasTest {
	Lambdas lambda = new Lambdas("These", "are", "a", "few", "test", "longword", "words");

	/**
	 * Test method for {@link com.ss.asgn5.Lamdas.Lambdas#sort()}.
	 */
	@Test
	void testSort() {
		List<String> words = lambda.getWords();
		lambda.sort();
		int length = 0;
		for (String word : words) {
			assertFalse(word.length() < length);
			length = word.length();
		}
	}

	/**
	 * Test method for {@link com.ss.asgn5.Lamdas.Lambdas#reverseSort()}.
	 */
	@Test
	void testReverseSort() {
		List<String> words = lambda.getWords();
		lambda.reverseSort();
		int length = words.get(0).length();
		for (String word : words) {
			assertFalse(word.length() > length);
			length = word.length();
		}
	}

	/**
	 * Test method for {@link com.ss.asgn5.Lamdas.Lambdas#alphaFirstCharSort()}.
	 */
	@Test
	void testAlphaFirstCharSort() {
		List<String> words = lambda.getWords();
		lambda.alphaFirstCharSort();
		int charCode = 0;
		for (String word : words) {
			assertFalse(word.toLowerCase().charAt(0) < charCode);
			charCode = word.toLowerCase().charAt(0);
		}
	}

	/**
	 * Test method for {@link com.ss.asgn5.Lamdas.Lambdas#sortContainsE()}.
	 */
	@Test
	void testSortContainsE() {
		List<String> words = lambda.getWords();
		
		lambda.sortContainsE();
		int index = 0;
		while (index < words.size() && words.get(index).contains("e")) {
			index++;
		}
		for (int i = index; i < words.size(); i++) {
			assertFalse(words.get(index).contains("e"));
		}
	}

	/**
	 * Test method for {@link com.ss.asgn5.Lamdas.Lambdas#listEvenOdd(java.lang.Integer[])}.
	 */
	@Test
	void testListEvenOdd() {
		String result = lambda.listEvenOdd(1, 2, 3, 4, 5);
		assertEquals(result, "o1,e2,o3,e4,o5");
	}

	/**
	 * Test method for {@link com.ss.asgn5.Lamdas.Lambdas#getThreeCharStringsA(java.util.List)}.
	 */
	@Test
	void testGetThreeCharStringsA() {
		lambda.setWords("abc", "aaaa", "Abc", "dac", "aaa");
		var words = lambda.getWords();
		var result = lambda.getThreeCharStringsA(words);
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), "abc");
		assertEquals(result.get(1), "aaa");
	}

}
