/**
 * 
 */
package com.ss.asgn3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author dlance
 * Question 2, Assignment 3
 *
 */
public class AppendToFile {

	/**
	 * @param args
	 * Append the text in args[1] to the file in args[0]
	 * java AppendToFile [file] [text]
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("You must provide a file and the text to append.");
			System.out.println("Format: java AppendToFile [file] [text]");
			return;
		}
		try {
			Files.write(Paths.get(args[0]), args[1].getBytes(), StandardOpenOption.APPEND);
			System.out.println("Successfully appended to file.");
		}
		catch (IOException e) {
			var output = "File `%s` does not exist. Please provide a valid file path.".formatted(args[0]);
			System.out.println(output);
		}
	}

}
