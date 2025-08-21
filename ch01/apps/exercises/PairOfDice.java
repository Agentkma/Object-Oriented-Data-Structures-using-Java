package ch01.apps.exercises;

import java.util.Random;

public class PairOfDice {
    private final Random rand = new Random();
    private final int sides;
    private int die1;
    private int die2;

    public PairOfDice() {
        this.sides = 6;
    }

    public void roll() {
        die1 = rand.nextInt(sides) + 1;
        die2 = rand.nextInt(sides) + 1;
    }

    public int value() {
        return die1 + die2;
    }

    public int getTotal() {
        return die1 + die2;
    }

    @Override
    public String toString() {
        return die1 + " + " + die2 + " = " + getTotal();
    }
}
