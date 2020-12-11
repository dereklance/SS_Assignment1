/**
 * 
 */
package com.ss.asgn3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author dlance
 * Question 3 Assignment 3
 *
 */
public class CountChar {

	/**
	 * @param args
	 * Count occurrences of the character args[1] in the file args[0]
	 */
	public static void main(String[] args) {	
		if (args.length != 2) {
			System.out.println("You must provide a file path and a character.");
			System.out.println("Format: java CountChar [file] [character]");
			return;
		}
		
		String filePath = args[0];
		String character = args[1];
		
		if (character.length() != 1) {
			System.out.println("Second argument must be a single character.");
			return;
		}
		
		char charToCount = character.charAt(0);
		
		try {
			String fileData = Files.readString(Paths.get(filePath));
			long occurences = fileData.chars()
				.filter(c -> c == charToCount)
				.count();
			System.out.println("The character `%c` occurred in the file %d times.".formatted(charToCount, occurences));
		}
		catch (IOException e) {
			var output = "File `%s` does not exist. Please provide a valid file path.".formatted(filePath);
			System.out.println(output);
		}
	}

}
