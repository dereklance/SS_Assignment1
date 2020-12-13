/**
 * 
 */
package com.ss.asgn5.DateTime;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dlance
 * Assignment 5 Functional / Recursion parts
 */
public class Functional {
	
	static List<Integer> rightDigit(List<Integer> numbers) {
		return numbers.stream()
				.map(num -> num % 10)
				.collect(Collectors.toList());
	}
	
	static List<Integer> doubling(List<Integer> numbers) {
		return numbers.stream()
				.map(num -> num * 2)
				.collect(Collectors.toList());
	}
	
	static List<String> noX(List<String> strings) {
		return strings.stream()
				.map(s -> s.replaceAll("x", ""))
				.collect(Collectors.toList());
	}
	
	static boolean groupSumClump(Integer index, int[] numbers, int targetSum) {
		if (index >= numbers.length) {
			return targetSum == 0;
		}
		
		Integer clumpStartIndex = index;
		Integer nextIndex = index + 1;
		while (nextIndex < numbers.length && numbers[nextIndex] == numbers[index]) {
			index++;
			nextIndex++;
		}
		
		boolean skipClump = groupSumClump(nextIndex, numbers, targetSum);
		
		Integer clumpSum = numbers[index] * (nextIndex - clumpStartIndex);
		boolean includeClump = groupSumClump(nextIndex, numbers, targetSum - clumpSum);
		
		return skipClump || includeClump;
	}
}
