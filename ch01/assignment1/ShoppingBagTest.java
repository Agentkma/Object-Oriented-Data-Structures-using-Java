package ch01.assignment1;

public class ShoppingBagTest {
    public static void main(String[] args) {
        int passedTests = 0;
        int totalTests = 5;

        // Test 1: Constructor with valid tax rate
        try {
            ShoppingBag bag = new ShoppingBag(0.07);
            if (bag.totalCost() != 0.0) { // Initially, total cost should be 0
                System.out.println("Test 1 failed");
                return;
            }
            System.out.println("Test 1 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 1 failed with exception: " + e.getMessage());
        }

        // Test 2: Constructor with negative tax rate
        try {
            new ShoppingBag(-0.05);
            System.out.println("Test 2 failed (exception not thrown)");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Test 2 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 2 failed with unexpected exception: " + e.getMessage());
        }

        // Test 3: Adding valid items
        try {
            ShoppingBag bag = new ShoppingBag(0.07);
            bag.place(3, 10.0);
            if (bag.totalCost() != 30.0 * (1 + 0.07)) { // Total cost with tax
                System.out.println("Test 3 failed");
                return;
            }
            System.out.println("Test 3 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 3 failed with exception: " + e.getMessage());
        }

        // Test 4: Adding items with negative price
        try {
            ShoppingBag bag = new ShoppingBag(0.07);
            bag.place(3, -10.0);
            System.out.println("Test 4 failed (exception not thrown)");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Test 4 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 4 failed with unexpected exception: " + e.getMessage());
        }

        // Test 5: toString method
        try {
            ShoppingBag bag = new ShoppingBag(0.07);
            bag.place(2, 15.0); // Add 2 items, each costing $15.00
            String expectedOutput = "The bag contains 2 items.  The retail cost of the items is  $30.00.  The total cost of the items, including tax is  $32.10.";
            if (!bag.toString().equals(expectedOutput)) {
                System.out.println("Test 5 failed");
                return;
            }
            System.out.println("Test 5 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 5 failed with exception: " + e.getMessage());
        }

        // Summary
        System.out.println(passedTests + " out of " + totalTests + " tests passed");
    }
}
