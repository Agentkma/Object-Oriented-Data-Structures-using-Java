package ch06.lists;

import ch06.lists.ABList;

public class TestIndexed {
    public static void main(String[] args) {
        int passedTests = 0;
        int totalTests = 3;

        System.out.println("Running Test 1: Add method");
        try {

            ABList<String> list = new ABList<String>();
            list.add(0, "John");
            String listContents = list.toString();

            if (!"John".equals(listContents.trim())) {
                throw new Exception("Unable to add");
            }

            System.out.println("Test 1 passed");
            passedTests++;

        } catch (Exception e) {
            System.out.println("Test 1 failed: " + e.getMessage());
        }

        System.out.println("Running Test 2: Remove method");
        try {
            ABList<String> list = new ABList<String>();

            list.add(0, "John");

            String removedJohn = list.remove(0);
            String listContents = list.toString();

            if (!"John".equals(removedJohn.trim()) || "John".equals(listContents.trim())) {
                throw new Exception("Unable to remove John for removal test");
            }

            System.out.println("Test 2 passed");
            passedTests++;

        } catch (Exception e) {
            System.out.println("Test 2 failed: " + e.getMessage());
        }

        System.out.println("Running Test 3: Get method");
        try {
            ABList<String> list = new ABList<String>();

            list.add(0, "John");

            String getTarget = list.get(0);

            if (!"John".equals(getTarget.trim())) {
                throw new Exception("target not equal to John for get test");
            }

            System.out.println("Test 3 passed");
            passedTests++;

        } catch (Exception e) {
            System.out.println("Test 3 failed: " + e.getMessage());
        }

        System.out.println(passedTests + " out of " + totalTests + " tests passed");
    }
}
