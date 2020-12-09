package com.ss.asgn2;

import java.util.Arrays;

public class AddCommandArgs {
	public static void main(String[] args) {
		int sum = Arrays.stream(args)
			.filter(str -> str.matches("-?\\d+"))
			.mapToInt(Integer::valueOf)
			.sum();
		System.out.println("Sum of command line arguments: " + sum);
	}
}
