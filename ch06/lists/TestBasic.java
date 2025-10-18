package ch06.lists;

import ch06.lists.ABList;

public class TestBasic {
    public static void main(String[] args) {
        int passedTests = 0;
        int totalTests = 5;

        System.out.println("Running Test 1: Add method");
        try {
            ABList<String> list = new ABList<String>();
            boolean addedJohn = list.add("John");
            String listContents = list.toString();

            if (!addedJohn || !"John".equals(listContents.trim())) {
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

            boolean addedJohn = list.add("John");
            if (!addedJohn) {
                throw new Exception("Unable to add John for removal test");
            }

            boolean removedJohn = list.remove("John");
            String listContents = list.toString();

            if (!removedJohn || "John".equals(listContents.trim())) {
                throw new Exception("Unable to remove John for removal test");
            }

            System.out.println("Test 2 passed");
            passedTests++;

        } catch (Exception e) {
            System.out.println("Test 2 failed: " + e.getMessage());
        }

        System.out.println("Running Test 3: Contains method");
        try {
            ABList<String> list = new ABList<String>();

            boolean addedJohn = list.add("John");
            if (!addedJohn) {
                throw new Exception("Unable to add John for contains test");
            }

            boolean containsJohn = list.contains("John");
            String listContents = list.toString();

            if (!containsJohn || !"John".equals(listContents.trim())) {
                throw new Exception("Contains John for contains test");
            }

            System.out.println("Test 3 passed");
            passedTests++;

        } catch (Exception e) {
            System.out.println("Test 3 failed: " + e.getMessage());
        }

        System.out.println("Running Test 4: Get method");
        try {
            ABList<String> list = new ABList<String>();

            boolean addedJohn = list.add("John");
            if (!addedJohn) {
                throw new Exception("Unable to add John for get test");
            }

            String getTarget = list.get("John");

            if (!"John".equals(getTarget.trim())) {
                throw new Exception("target not equal to John for get test");
            }

            System.out.println("Test 4 passed");
            passedTests++;

        } catch (Exception e) {
            System.out.println("Test 4 failed: " + e.getMessage());
        }

        System.out.println("Running Test 5: Size method");
        try {
            ABList<String> list = new ABList<String>();

            boolean addedJohn = list.add("John");
            if (!addedJohn) {
                throw new Exception("Unable to add John for size test");
            }

            int size = list.size();

            if (size != 1) {
                throw new Exception("size not equal to 1 for size test");
            }

            System.out.println("Test 5 passed");
            passedTests++;

        } catch (Exception e) {
            System.out.println("Test 5 failed: " + e.getMessage());
        }

        System.out.println(passedTests + " out of " + totalTests + " tests passed");
    }
}
