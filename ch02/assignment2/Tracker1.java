package ch02.assignment2;

public class Tracker1 implements NumTrackerInterface {
    private int count;
    private int sum;
    private double average;

    public Tracker1() {
        count = 0;
        sum = 0;
        average = 0;
    }

    @Override
    public void add(int number) {
        count++;
        sum += number;

        if (count == 0) {
            average = 0;
            return;
        }
        average = (double) sum / count;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int getSum() {
        return sum;
    }

    @Override
    public double getAverage() {
        return average;
    }
}
