package ch01.assignment1;

public class PolynomialTest {
    public static void main(String[] args) {
        int passedTests = 0;
        int totalTests = 4;

        // Test 1: Constructor and evaluate with zero coefficients
        try {
            Polynomial poly = new Polynomial(3);
            if (poly.evaluate(2) != 0.0) { // All coefficients are 0, so result should be 0
                System.out.println("Test 1 failed");
                return;
            }
            System.out.println("Test 1 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 1 failed with exception: " + e.getMessage());
        }

        // Test 2: Setting and evaluating coefficients
        try {
            Polynomial poly = new Polynomial(3);
            poly.setCoefficient(0, 1); // Constant term
            poly.setCoefficient(1, 2); // Linear term
            poly.setCoefficient(2, 3); // Quadratic term
            poly.setCoefficient(3, 4); // Cubic term

            double expectedValue = 1 + 2 * 2 + 3 * Math.pow(2, 2) + 4 * Math.pow(2, 3); // Evaluate at x = 2
            if (poly.evaluate(2) != expectedValue) {
                System.out.println("Test 2 failed");
                return;
            }
            System.out.println("Test 2 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 2 failed with exception: " + e.getMessage());
        }

        // Test 3: Setting coefficient out of bounds
        try {
            Polynomial poly = new Polynomial(3);
            poly.setCoefficient(4, 5); // Invalid term degree
            System.out.println("Test 3 failed (exception not thrown)");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Test 3 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 3 failed with unexpected exception: " + e.getMessage());
        }

        // Test 4: Evaluate with negative x
        try {
            Polynomial poly = new Polynomial(2);
            poly.setCoefficient(0, 1); // Constant term
            poly.setCoefficient(1, -2); // Linear term
            poly.setCoefficient(2, 3); // Quadratic term

            double expectedValue = 1 - 2 * (-1) + 3 * Math.pow(-1, 2); // Evaluate at x = -1
            if (poly.evaluate(-1) != expectedValue) {
                System.out.println("Test 4 failed");
                return;
            }
            System.out.println("Test 4 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 4 failed with exception: " + e.getMessage());
        }

        // Summary
        System.out.println(passedTests + " out of " + totalTests + " tests passed");
    }
}
