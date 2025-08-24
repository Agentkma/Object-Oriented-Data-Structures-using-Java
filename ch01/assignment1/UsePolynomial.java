package ch01.assignment1;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UsePolynomial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length < 2) {
            System.out.println("Welcome to the Polynomial Program!");
            System.out.println(
                    "To start, you can provide the degree of the polynomial followed by its coefficients as command-line arguments.");
            System.out.println("For example: java UsePolynomial 3 5 0 2 -3");
            System.out.println("This represents the polynomial: 5x^3 + 2x - 3");

            System.out.print("Enter the degree and coefficients separated by spaces (e.g., 3 5 0 2 -3): ");
            String input = scanner.nextLine();

            // Split input while preserving negative numbers
            args = input.trim().split(" ");
        }

        Polynomial polynomial = null;
        try {

            int highestDegree = Integer.parseInt(args[0]);
            String[] coefficients = Arrays.copyOfRange(args, 1, args.length);
            // Reverse the order so coefficients are in ascending order
            // this aligns the coefficient with its term degree as we expect
            // to set them
            Collections.reverse(Arrays.asList(coefficients));

            polynomial = new Polynomial(highestDegree);
            for (int termDegree = 0; termDegree <= highestDegree; termDegree++) {
                int coefficient = Integer.parseInt(coefficients[termDegree]);
                polynomial.setCoefficient(termDegree, coefficient);
            }

            System.out.println("Polynomial created successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in arguments.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        while (true) {

            try {
                System.out.print("Enter a value: ");
                double value = scanner.nextDouble();

                double result = polynomial.evaluate(value);
                System.out.println("The result is: " + result);

                System.out.print("Continue? (yes/no): ");
                String answer = scanner.next();

                if (answer.equalsIgnoreCase("no")) {
                    System.out.println("Exiting...");
                    break;
                } else if (!answer.equalsIgnoreCase("yes")) {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.next(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
