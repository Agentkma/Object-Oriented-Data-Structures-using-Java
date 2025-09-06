package ch02.assignment2;

/**
 * An interface for tracking numbers and calculating statistics.
 * Implementations of this interface should provide mechanisms
 * to add numbers and retrieve statistical information such as
 * count, sum, and average.
 */
public interface NumTrackerInterface {

    /**
     * Adds a number to the tracker.
     *
     * @param number the number to be added
     */
    void add(int number);

    /**
     * Returns the count of numbers added to the tracker.
     *
     * @return the count of numbers
     */
    int getCount();

    /**
     * Returns the sum of all numbers added to the tracker.
     *
     * @return the sum of numbers
     */
    int getSum();

    /**
     * Returns the average of all numbers added to the tracker.
     * If no numbers have been added, the behavior should be defined
     * by the implementing class (e.g., return 0 or throw an exception).
     *
     * @return the average of numbers
     */
    double getAverage();
}
