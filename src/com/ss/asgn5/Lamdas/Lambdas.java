/**
 * 
 */
package com.ss.asgn5.Lamdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dlance
 *
 */
public class Lambdas {
	
	private List<String> words;
	
	public Lambdas(String ...words) {
		this.words = Arrays.asList(words);
	}
	
	public void setWords(String ...words) {
		this.words = Arrays.asList(words);
	}
	
	public List<String> getWords() {
		return words;
	}
	
	public void sort() {
		this.words.sort((s1, s2) -> s1.length() - s2.length());
	}
	
	public void reverseSort() {
		this.words.sort((s1, s2) -> s2.length() - s1.length());
	}
	
	// sort based on first character, alphabetically (upper case characters are treated as lower case for sorting)
	public void alphaFirstCharSort() {
		this.words.sort((s1, s2) -> s1.toLowerCase().charAt(0) - s2.toLowerCase().charAt(0));
	}
	
	private static int containsEComparator(String s1, String s2) {
		int c1 = s1.contains("e") ? 1 : 0;
		int c2 = s2.contains("e") ? 1 : 0;
		return c2 - c1;
	}
	
	public void sortContainsE() {
		this.words.sort((s1, s2) -> containsEComparator(s1, s2));
	}
	
	// Number 2... input (3,44) -> output 'o3,e44'
	public String listEvenOdd(Integer ...numbers) {
		return Arrays.asList(numbers).stream()
			.map(number -> (number % 2 == 0 ? "e" : "o") + number)
			.collect(Collectors.joining(","));
	}
	
	public List<String> getThreeCharStringsA(List<String> strings) {
		return strings.stream()
			.filter(s -> s.length() == 3 && s.charAt(0) == 'a')
			.collect(Collectors.toList());
	}
}
