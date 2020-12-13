/**
 * 
 */
package com.ss.asgn4.LineTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author dlance
 *
 */
class LineTest {

	/**
	 * Test method for {@link com.ss.asgn4.LineTesting.Line#getSlope()}.
	 */
	@Test
	void testGetSlope() {
		Line line = new Line(1, 1, 1, 1);
		assertThrows(ArithmeticException.class, line::getSlope);
		
		line = new Line(1, 2, 2, 4);
		double delta = 0.0001;
		double expected = 2.0;
		double difference = Math.abs(line.getSlope() - expected);
		assertTrue(difference < delta);
	}

	/**
	 * Test method for {@link com.ss.asgn4.LineTesting.Line#getDistance()}.
	 */
	@Test
	void testGetDistance() {
		Line line = new Line(1, 2, 2, 4);
		double delta = 0.0001;
		double expected = Math.sqrt(5);
		double difference = Math.abs(line.getDistance() - expected);
		assertTrue(difference < delta);
	}

	/**
	 * Test method for {@link com.ss.asgn4.LineTesting.Line#parallelTo(com.ss.asgn4.LineTesting.Line)}.
	 */
	@Test
	void testParallelTo() {
		Line line1 = new Line(1, 2, 2, 4);
		Line line2 = new Line(4, 8, 12, 24);
		
		assertTrue(line1.parallelTo(line2));
		assertTrue(line2.parallelTo(line1));
		
		line1 = new Line(1, 2, 2, 5);
		assertFalse(line1.parallelTo(line2));
		assertFalse(line2.parallelTo(line1));
	}

}
