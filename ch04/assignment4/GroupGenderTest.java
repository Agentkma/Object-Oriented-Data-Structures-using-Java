package ch04.assignment4;

public class GroupGenderTest {
    public static void main(String[] args) {
        int passedTests = 0;
        int totalTests = 3;

        System.out.println("Running Test 1: Add male and female names");
        try {
            GroupGender group = new GroupGender();
            boolean addedMale = group.addPerson("M John");
            boolean addedFemale = group.addPerson("F Jane");
            if (addedMale && addedFemale) {
                System.out.println("Test 1 passed");
                passedTests++;
            } else {
                System.out.println("Test 1 failed: Unable to add names");
            }
        } catch (Exception e) {
            System.out.println("Test 1 failed: " + e.getMessage());
        }

        System.out.println("Running Test 2: Exceed maximum names per gender");
        try {
            GroupGender group = new GroupGender();
            boolean allAdded = true;
            for (int i = 0; i < 10; i++) {
                allAdded &= group.addPerson("M MaleName" + i);
            }
            boolean exceeded = !group.addPerson("M ExtraMale");
            if (allAdded && exceeded) {
                System.out.println("Test 2 passed");
                passedTests++;
            } else {
                System.out.println("Test 2 failed: Did not handle maximum capacity correctly");
            }
        } catch (Exception e) {
            System.out.println("Test 2 failed: " + e.getMessage());
        }

        System.out.println("Running Test 3: List genders");
        try {
            GroupGender group = new GroupGender();
            group.addPerson("M John");
            group.addPerson("F Jane");
            group.addPerson("M Fred");
            group.addPerson("F Coleen");
            String list = group.retrieveGenders();
            System.out.println("Expected: males: John Fred females: Jane Coleen ");
            System.out.println("Actual: " + list);
            if (list.equals("males: John Fred females: Jane Coleen ")) {
                System.out.println("Test 3 passed");
                passedTests++;
            } else {
                System.out.println("Test 3 failed: Incorrect list output");
            }
        } catch (Exception e) {
            System.out.println("Test 3 failed: " + e.getMessage());
        }

        System.out.println(passedTests + " out of " + totalTests + " tests passed");
    }
}
