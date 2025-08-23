package ch01.assignment1;

public class Polynomial {
    private int degree;
    private int[] coefficients;

    public Polynomial(int degree) {
        this.degree = degree;
        this.coefficients = new int[degree + 1]; // Array to store coefficients for terms from 0 to degree
        // Coefficients are initialized to 0 by default
    }

    // example: setting the coefficient for 5x^3
    // setCoefficient(3, 5);
    public void setCoefficient(int termDegree, int coefficient) {
        if (termDegree < 0 || termDegree > degree) {
            throw new IllegalArgumentException("Term degree out of bounds");
        }
        // index 3 is set to value of 5... coefficients = [_,_,_, 5]
        this.coefficients[termDegree] = coefficient;

    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i <= degree; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

}
