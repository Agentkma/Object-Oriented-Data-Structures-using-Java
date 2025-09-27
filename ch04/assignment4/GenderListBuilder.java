package ch04.assignment4;

import java.util.Scanner;

public class GenderListBuilder {
    private static final String DONE = "x done";

    public static void main(String[] args) {
        // using try-with-resource here so we safely close the scanner automatically
        // when done or error
        try (Scanner scan = new Scanner(System.in)) {

            GroupGender group = new GroupGender();
            processInput(group, scan);
            System.out.println(group.retrieveGenders());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static boolean isDone(String input) {
        return input.equalsIgnoreCase(DONE);
    }

    private static void processInput(GroupGender group, Scanner scan) {
        String input;
        do {
            System.out.println("Input a gender and name (x done to quit)");
            input = scan.nextLine();
            if (!isDone(input)) {
                boolean added = group.addPerson(input);
                if (!added) {
                    System.out.println("List is full for that gender");
                }
            }
        } while (!isDone(input));
    }
}
