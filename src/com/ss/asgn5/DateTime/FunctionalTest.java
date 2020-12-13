package com.ss.asgn5.DateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class FunctionalTest {

	@Test
	void testRightDigit() {
		List<Integer> result = Functional.rightDigit(Arrays.asList(1, 22, 93));
		assertEquals(result, Arrays.asList(1, 2, 3));
		
		result = Functional.rightDigit(Arrays.asList(16, 8, 886, 8, 1));
		assertEquals(result, Arrays.asList(6, 8, 6, 8, 1));
		
		result = Functional.rightDigit(Arrays.asList(10, 0));
		assertEquals(result, Arrays.asList(0, 0));
	}

	@Test
	void testDoubling() {
		List<Integer> result = Functional.doubling(Arrays.asList(1, 2, 3));
		assertEquals(result, Arrays.asList(2, 4, 6));
		
		result = Functional.doubling(Arrays.asList(6, 8, 6, 8, -1));
		assertEquals(result, Arrays.asList(12, 16, 12, 16, -2));
		
		result = Functional.doubling(Arrays.asList());
		assertEquals(result, Arrays.asList());
	}

	@Test
	void testNoX() {
		List<String> result = Functional.noX(Arrays.asList("ax", "bb", "cx"));
		assertEquals(result, Arrays.asList("a", "bb", "c"));
		
		result = Functional.noX(Arrays.asList("xxax", "xbxbx", "xxcx"));
		assertEquals(result, Arrays.asList("a", "bb", "c"));
		
		result = Functional.noX(Arrays.asList("x"));
		assertEquals(result, Arrays.asList(""));
	}

	@Test
	void testGroupSumClump() {
		assertTrue(Functional.groupSumClump(0, new int[] {2, 4, 8}, 10));
		assertTrue(Functional.groupSumClump(0, new int[] {1, 2, 4, 8, 1}, 14));
		assertFalse(Functional.groupSumClump(0, new int[] {2, 4, 4, 8}, 14));
	}

}
