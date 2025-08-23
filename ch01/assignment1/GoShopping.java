package ch01.assignment1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class GoShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingBag bag = new ShoppingBag(0.06); // 6% tax rate
        int stopCode = 0;

        while (true) {
            int count = 0;
            double cost = 0.0;

            try {
                System.out.print("Enter count (use 0 to stop): ");
                count = scanner.nextInt();

                if (count == stopCode) {
                    break;
                }

                System.out.print("Enter cost: ");
                cost = scanner.nextDouble();

                // Add items to the bag
                bag.place(count, cost);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
                scanner.next(); // Clear invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println(bag);
        scanner.close();
    }
}
