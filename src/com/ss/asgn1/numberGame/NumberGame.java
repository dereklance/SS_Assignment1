/**
	Play a number game:
	1. user guesses a number between 1-100
	2. generate random number
	3. 5 chances to guess number
	4. user wins if the guess is 10 or less away from actual number
 * 
 */
package com.ss.asgn1.numberGame;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author dlance
 *
 */
public class NumberGame {

	public void playGame() {
		Scanner input = new Scanner(System.in);
		int number = (int) (Math.random() * 100 + 1);
		boolean win = false;
		
		for (int i = 0; i < 5; i++) {
			int guess;
			System.out.print("Guess a number between 1-100: ");
			if (input.hasNextInt()) {
				guess = input.nextInt();
			}
			else {
				System.out.println("Invalid input, please try again.");
				input.next();
				i--;
				continue;
			}
			if (Math.abs(number - guess) <= 10) {
				win = true;
				break;
			}
		}
		if (win) {
			System.out.println("You win! The number was: " + number);
		}
		else {
			System.out.println("Sorry. The number was: " + number);
		}
		input.close();
		
	}

	public static void main(String[] args) {
		new NumberGame().playGame();
	}

}
