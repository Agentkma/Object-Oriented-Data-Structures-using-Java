package ch01.dates;

public class DateTest {
    public static void main(String[] args) {
        // Create test Date objects
        Date date1 = new Date(1, 1, 2000); // January 1, 2000
        Date date2 = new Date(1, 1, 2010); // January 1, 2010
        Date date3 = new Date(1, 1, 2000); // January 1, 2000 (same as date1)

        // Test when date1 is earlier than date2
        if (date1.compareTo(date2) == -1) {
            System.out.println("Test Passed: date1 is earlier than date2");
        } else {
            System.out.println("Test Failed: date1 is not earlier than date2");
        }

        // Test when date1 is the same as date3
        if (date1.compareTo(date3) == 0) {
            System.out.println("Test Passed: date1 is equal to date3");
        } else {
            System.out.println("Test Failed: date1 is not equal to date3");
        }

        // Test when date2 is later than date1
        if (date2.compareTo(date1) == 1) {
            System.out.println("Test Passed: date2 is later than date1");
        } else {
            System.out.println("Test Failed: date2 is not later than date1");
        }
    }
}