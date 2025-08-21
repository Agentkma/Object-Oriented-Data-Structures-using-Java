//----------------------------------------------------------------------
// EnterAnInteger.java          by Kevin Anderson               Chapter 1
//
// Asks the user to enter an integer and then reports 
// the integer entered by the user.
//----------------------------------------------------------------------

package ch01.apps;

import java.util.Scanner;
import ch01.exercises.ExceptionInteger;

public class EnterAnInteger {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      ExceptionInteger validator = new ExceptionInteger();
      String userInput;

      while (true) {
        System.out.print("Please enter an integer: ");
        userInput = scan.nextLine().trim();

        if (validator.isValidInteger(userInput)) {
          int value = Integer.parseInt(userInput);
          System.out.println("You entered: " + value);
          System.out.println("Thank You");
          break;
        } else {
          System.out.println("That is not an integer. Please enter an integer.");
        }
      }

    } // Scanner closed here
  }
}