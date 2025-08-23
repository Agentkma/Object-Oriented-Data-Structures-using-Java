package ch01.assignment1;

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
            int degree = Integer.parseInt(args[0]);
            if (args.length != degree + 2) {
                System.out
                        .println("Error: Number of coefficients provided does not match the degree of the polynomial.");
                scanner.close();
                return;
            }

            polynomial = new Polynomial(degree);
            for (int termDegree = 0; termDegree <= degree; termDegree++) {
                // Map the descending input coefficients to ascending order in the coefficients
                // array.
                // The Polynomial class uses an array where the index represents the degree of
                // the term.
                // For example, a degree of 3 corresponds to index 3 in the array.
                // Since user input provides coefficients in descending order, we calculate the
                // correct index
                // by subtracting the current term degree from the polynomial degree and adding
                // 1 to offset the initial degree arg.
                int indexForTermDegree = degree - termDegree + 1;
                int coefficient = Integer.parseInt(args[indexForTermDegree]);

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
