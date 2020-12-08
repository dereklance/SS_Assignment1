/**
	Print out 4 different patterns
 * 
 */
package com.ss.asgn1.printPatterns;

/**
 * @author dlance
 *
 */
public class Patterns {

	private void printNumber(int number) {
		System.out.println(number + ")");
	}

	// Prints a string the given number of times on one line
	private void printStringTimes(String c, int times, boolean newline) {
		for (int i = 0; i < times; i++) {
			System.out.print(c);
		}
		if (newline) {
			System.out.println();
		}
	}

	public void print1() {
		printNumber(1);
		for (int i = 1; i <= 4; i++) {
			printStringTimes("*", i, true);
		}
		printStringTimes(".", 9, true);
		System.out.println();
	}

	public void print2() {
		printNumber(2);
		printStringTimes(".", 10, true);
		for (int i = 4; i >=0; i--) {
			printStringTimes("*", i, true);
		}
		System.out.println();
	}
	
	public void print3() {
		printNumber(3);
		printStringTimes(" ", 5, false);
		printStringTimes("*", 1, true);
		printStringTimes(" ", 4, false);
		printStringTimes("*", 3, true);
		printStringTimes(" ", 3, false);
		printStringTimes("*", 5, true);
		printStringTimes(" ", 2, false);
		printStringTimes("*", 7, true);
		printStringTimes(".", 11, true);
		System.out.println();
	}
	
	public void print4() {
		printNumber(4);
		printStringTimes(".", 12, true);
		printStringTimes(" ", 2, false);
		printStringTimes("*", 7, true);
		printStringTimes(" ", 3, false);
		printStringTimes("*", 5, true);
		printStringTimes(" ", 4, false);
		printStringTimes("*", 3, true);
		printStringTimes(" ", 5, false);
		printStringTimes("*", 1, true);
		System.out.println();
	}

	public static void main(String[] args) {
		Patterns pattern = new Patterns();

		pattern.print1();
		pattern.print2();
		pattern.print3();
		pattern.print4();
	}

}
