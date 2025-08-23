package ch01.assignment1;

public class ShoppingBag {
    private int itemCount;
    private double totalRetailCost;
    private final double taxRate;

    public ShoppingBag(double taxRate) {
        validateNumberIsPositive(taxRate, "Tax rate cannot be negative");
        this.taxRate = taxRate;
        this.itemCount = 0;
        this.totalRetailCost = 0.0;
    }

    public void place(int count, double pricePerItem) {
        validateNumberIsPositive(count, "Item count cannot be negative");
        validateNumberIsPositive(pricePerItem, "Price per item cannot be negative");
        this.itemCount += count;
        this.totalRetailCost += count * pricePerItem;
    }

    private static void validateNumberIsPositive(Number value, String errorMessage) {
        if (value.doubleValue() < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public double totalCost() {
        return totalRetailCost * (1.0 + taxRate);
    }

    @Override
    public String toString() {
        return String.format(
                "The bag contains %d items.  The retail cost of the items is  $%.2f.  The total cost of the items, including tax is  $%.2f.",
                itemCount, totalRetailCost, totalCost());
    }
}