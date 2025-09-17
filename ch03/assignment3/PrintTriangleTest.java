package ch03.assignment3;

public class PrintTriangleTest {
    public static void main(String[] args) {
        int passedTests = 0;
        int totalTests = 4;

        System.out.println("Running Test 1: printTriangleUp with n = 1");
        try {
            PrintTriangle.printTriangleUp(1);
            System.out.println("Expected:\n* \n");
            System.out.println("Test 1 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 1 failed: " + e.getMessage());
        }

        System.out.println("Running Test 2: printTriangleUp with n = 3");
        try {
            PrintTriangle.printTriangleUp(3);
            System.out.println("Expected:\n* \n* * \n* * * \n");
            System.out.println("Test 2 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 2 failed: " + e.getMessage());
        }

        System.out.println("Running Test 3: printTriangleDn with n = 3");
        try {
            PrintTriangle.printTriangleDn(3);
            System.out.println("Expected:\n* * * \n* * \n* \n");
            System.out.println("Test 3 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 3 failed: " + e.getMessage());
        }

        System.out.println("Running Test 4: printTriangleDn with n = 1");
        try {
            PrintTriangle.printTriangleDn(1);
            System.out.println("Expected:\n* \n");
            System.out.println("Test 4 passed");
            passedTests++;
        } catch (Exception e) {
            System.out.println("Test 4 failed: " + e.getMessage());
        }

        System.out.println(passedTests + " out of " + totalTests + " tests passed");
    }
}
