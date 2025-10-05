package ch05.collections;

public class LinkedCollectionTest {
    public static void main(String[] args) {
        int passedTests = 0;
        int totalTests = 3;

        System.out.println("Running Test 1: toString method");
        try {
            LinkedCollection<String> collection = new LinkedCollection<>();
            collection.add("A");
            collection.add("B");
            collection.add("C");
            String result = collection.toString();
            System.out.println("Expected: C, B, A");
            System.out.println("Actual: " + result);
            if (result.equals("C, B, A")) {
                System.out.println("Test 1 passed");
                passedTests++;
            } else {
                System.out.println("Test 1 failed: Incorrect toString output");
            }
        } catch (Exception e) {
            System.out.println("Test 1 failed: " + e.getMessage());
        }

        System.out.println("Running Test 2: count method");
        try {
            LinkedCollection<String> collection = new LinkedCollection<>();
            collection.add("A");
            collection.add("B");
            collection.add("A");
            collection.add("C");
            collection.add("A");
            int count = collection.count("A");
            System.out.println("Expected: 3");
            System.out.println("Actual: " + count);
            if (count == 3) {
                System.out.println("Test 2 passed");
                passedTests++;
            } else {
                System.out.println("Test 2 failed: Incorrect count output");
            }
        } catch (Exception e) {
            System.out.println("Test 2 failed: " + e.getMessage());
        }

        System.out.println("Running Test 3: removeAll method");
        try {
            LinkedCollection<String> collection = new LinkedCollection<>();
            collection.add("A");
            collection.add("B");
            collection.add("A");
            collection.add("C");
            collection.add("A");

            // Verify size before removeAll
            int sizeBefore = collection.size();
            System.out.println("Size before removeAll: " + sizeBefore);

            collection.removeAll("A");

            // Verify size after removeAll
            int sizeAfter = collection.size();
            System.out.println("Size after removeAll: " + sizeAfter);

            String result = collection.toString();
            System.out.println("Expected: C, B");
            System.out.println("Actual: " + result);

            if (result.equals("C, B") && sizeBefore == 5 && sizeAfter == 2) {
                System.out.println("Test 3 passed");
                passedTests++;
            } else {
                System.out.println("Test 3 failed: Incorrect removeAll output or size verification");
            }
        } catch (Exception e) {
            System.out.println("Test 3 failed: " + e.getMessage());
        }

        System.out.println(passedTests + " out of " + totalTests + " tests passed");
    }
}
