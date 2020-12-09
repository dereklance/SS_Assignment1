package com.ss.asgn2;

public class MaxArray {
	public static void main(String[] args) {
		int[][] array = {{1, 2, 3, 4, 5},
				         {84, 11, 13, 8, 40},
				         {3, 7, -100, 44, 80},
				         {2}};
		
		int max = array[0][0];
		int xPos = 0, yPos = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > max) {
					max = array[i][j];
					xPos = i;
					yPos = j;
				}
			}
		}
		
		System.out.println("Maximum value of array is: " + max);
		System.out.println("Found at position: " + "(" + xPos + ", " + yPos + ")");
	}
}
