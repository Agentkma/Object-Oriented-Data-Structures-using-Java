package ch01.assignment1;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateIntegral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length < 2) {
            System.out.println("Welcome to the Calculate Integral Program!");
            System.out.println(
                    "To start, you can provide the degree of the polynomial followed by its coefficients as command-line arguments.");
            System.out.println("For example: java CalculateIntegral 3 5 0 2 -3");
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
            // could use a reverseIndex instead of reversing the list,
            // but I like this way better for readability and
            // copying the list takes more memory and may be slower
            // but both have Big O complexity of O(n) , so keeping like this
            // especially for small lists

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

        double a = 0, b = 0;
        try {
            System.out.print("Now you need to enter the interval endpoints.\n");
            System.out.print("Enter the start of the interval (a): ");
            a = scanner.nextDouble();

            System.out.print("Enter the end of the interval (b): ");
            b = scanner.nextDouble();

            // Calculate the definite integral using 1000 bounding rectangles
            int n = 1000; // Number of rectangles for approximation
            double width = (b - a) / n;
            double integral = 0;

            for (int i = 0; i < n; i++) {
                double x = a + i * width;
                integral += polynomial.evaluate(x) * width;
            }

            System.out.printf(
                    "The approximate definite integral of the polynomial on [%.2f, %.2f] using 1000 rectangles is: %.4f\n",
                    a, b, integral);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers for the interval.");
            scanner.next(); // Clear invalid input
        }

        scanner.close();
    }
}
