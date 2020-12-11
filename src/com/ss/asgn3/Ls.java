/**
 * 
 */
package com.ss.asgn3;

import java.io.File;
import java.util.Arrays;

/**
 * @author dlance
 * Question 1, Assignment 3
 */
public class Ls {

	/**
	 * @param args
	 * Lists all files/directories under args[0]
	 * Lists all file/directories under current directory if no args are passed
	 */
	public static void main(String[] args) {
		var directoryPath = args.length > 0 ? args[0] : ".";
		var directory = new File(directoryPath);
		
		Arrays.stream(directory.list())
			.forEach(System.out::println);

	}

}
