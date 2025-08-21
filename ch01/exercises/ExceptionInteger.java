package ch01.exercises;

public class ExceptionInteger {

    public ExceptionInteger() {

    }

    public boolean isValidInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
