package ch02.assignment2;

public class Tracker2 implements NumTrackerInterface {
    private int count;
    private int sum;

    public Tracker2() {
        count = 0;
        sum = 0;
    }

    @Override
    public void add(int number) {
        count++;
        sum += number;
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
        if (count == 0) {
            return 0;
        }
        return (double) sum / count;
    }
}
