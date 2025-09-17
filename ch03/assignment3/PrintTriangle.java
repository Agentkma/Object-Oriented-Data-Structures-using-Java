package ch03.assignment3;

/**
 * Prints a triangle of asterisks
 */
public class PrintTriangle {
    /**
     * Prints a triangle of asterisks with rows increasing from 1 to n.
     * Each row contains a number of asterisks equal to its row number.
     *
     * @param n the number of rows in the triangle; must be a positive integer
     */
    public static void printTriangleUp(int n) {

        // base case
        if (n == 0) {
            return;
        }

        // recursive case and smaller case
        // call the recursive method before printing since we want
        // to print the smallest case (1) first
        printTriangleUp(n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();// move cursor to the next line
    }

    /**
     * Prints a triangle of asterisks with rows decreasing from n to 1.
     * Each row contains a number of asterisks equal to its row number.
     *
     * @param n the number of rows in the triangle; must be a positive integer
     */
    public static void printTriangleDn(int n) {

        // base case
        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();// move cursor to the next line

        // general/recursive case and smaller case
        // call the recursive method after printing since we want
        // to print the largest case (n) first
        printTriangleDn(n - 1);
    }
}
