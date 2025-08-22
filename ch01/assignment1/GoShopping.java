package ch01.assignment1;

import java.util.Scanner;

public class GoShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingBag bag = new ShoppingBag(0.07); // 7% tax rate

        while (true) {
            System.out.print("Enter count (use 0 to stop): ");
            int count = scanner.nextInt();

            if (count == 0) {
                break;
            }

            System.out.print("Enter cost: ");
            double cost = scanner.nextDouble();

            try {
                bag.place(count, cost);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println(bag);

        scanner.close();
    }
}
