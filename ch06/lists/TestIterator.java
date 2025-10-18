package ch06.lists;

import ch06.lists.ABList;

public class TestIterator {
    public static void main(String[] args) {
        int passedTests = 0;
        int totalTests = 1;

        System.out.println("Running Test 1: hasNext, next, and remove work");
        try {

            ABList<String> list = new ABList<String>();
            list.add("John");
            String listContents = list.toString();

            if (!"John".equals(listContents.trim())) {
                throw new Exception("Unable to add");
            }

            var iterator = list.iterator();

            if (!iterator.hasNext()) {
                throw new Exception("hasNext returned false incorrectly");
            }
            String name = iterator.next();
            if (!"John".equals(name)) {
                throw new Exception("next did not return correct value");
            }

            iterator.remove();
            listContents = list.toString();
            if (!"".equals(listContents.trim())) {
                throw new Exception("remove did not remove the element");
            }

            System.out.println("Test 1 passed");
            passedTests++;

        } catch (Exception e) {
            System.out.println("Test 1 failed: " + e.getMessage());
        }

        System.out.println(passedTests + " out of " + totalTests + " tests passed");
    }
}
