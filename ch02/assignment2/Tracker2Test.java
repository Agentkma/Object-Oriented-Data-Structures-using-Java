package ch02.assignment2;

public class Tracker2Test {
    public static void main(String[] args) {
        int passedTests = 0;
        int totalTests = 4;

        System.out.println("Running Test 1: Initial state");
        Tracker2 tracker = new Tracker2();
        if (tracker.getCount() != 0 || tracker.getSum() != 0 || tracker.getAverage() != 0.0) {
            System.out.println("Test 1 failed");
        } else {
            System.out.println("Test 1 passed");
            passedTests++;
        }

        System.out.println("Running Test 2: Adding a single number");
        tracker = new Tracker2();
        tracker.add(10);
        if (tracker.getCount() != 1 || tracker.getSum() != 10 || tracker.getAverage() != 10.0) {
            System.out.println("Test 2 failed");
        } else {
            System.out.println("Test 2 passed");
            passedTests++;
        }

        System.out.println("Running Test 3: Adding multiple numbers");
        tracker = new Tracker2();
        tracker.add(10);
        tracker.add(20);
        tracker.add(30);
        if (tracker.getCount() != 3 || tracker.getSum() != 60 || tracker.getAverage() != 20.0) {
            System.out.println("Test 3 failed");
        } else {
            System.out.println("Test 3 passed");
            passedTests++;
        }

        System.out.println("Running Test 4: Edge case - Adding zero");
        tracker = new Tracker2();
        tracker.add(0);
        if (tracker.getCount() != 1 || tracker.getSum() != 0 || tracker.getAverage() != 0.0) {
            System.out.println("Test 4 failed");
        } else {
            System.out.println("Test 4 passed");
            passedTests++;
        }

        System.out.println(passedTests + " out of " + totalTests + " tests passed");
    }
}
