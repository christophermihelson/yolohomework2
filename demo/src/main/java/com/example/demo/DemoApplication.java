package com.example.demo;

import java.util.Scanner;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		try (Scanner inp = new Scanner(System.in)) {
			int number = 0;
			double bet = 0;
			String input = "";
			String input2 = "";
			boolean isStringNumber = true;// If the String is not Number
			while (true) {

				System.out.println("\nPlease enter a number from 1-99");
				input = inp.nextLine();

				isStringNumber = input.matches("^([1-9][0-9]?|)$");// Check if no digits in string

				if (isStringNumber == false) {
					System.out.println("\nInvalid number: " + input);
					continue;
				}

				else {

					System.out.println("\nPlease enter a bet amount");
					input2 = inp.nextLine();
					isStringNumber = input2.matches("[0-9]{1,13}(\\.[0-9]+)?");// Check if no digits in string

					while (isStringNumber == false) {

						System.out.println("\nInvalid bet amount: " + input2);
						System.out.println("\nPlease enter a bet amount");
						input2 = inp.nextLine();
						isStringNumber = input2.matches("[0-9]{1,13}(\\.[0-9]+)?");// Check if no digits in string
					}
				}

				if (isStringNumber == true) {
					number = Integer.parseInt(input);
					bet = Double.parseDouble(input2);
					double number2 = number;
					double bet2 = bet;

					Random randomInt = new Random();
					int randomNumber = randomInt.nextInt(99);
					randomNumber = randomNumber + 1;
					System.out.println("\nYour number is " + number + " and you bet " + bet);
					System.out.println("\nGenerated random number is " + randomNumber);

					double win = bet2 * (99 / (100 - number2));

					if (number > randomNumber)
						System.out.println("\nYour number was bigger, you won " + win);
					if (number <= randomNumber)
						System.out.printf("\nYour number is lower, you lost.");
				}

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
