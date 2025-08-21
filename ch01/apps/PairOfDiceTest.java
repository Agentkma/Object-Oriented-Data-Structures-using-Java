package ch01.exercises;

public class PairOfDiceTest {
    public static void main(String[] args) {
        int passed = 0;
        int total = 0;

        total++;
        if (testDefaultTotalRange()) {
            System.out.println("Test Passed: defaultTotalRange");
            passed++;
        } else {
            System.out.println("Test Failed: defaultTotalRange");
        }
        total++;
        if (testCustomTotalRange()) {
            System.out.println("Test Passed: customTotalRange");
            passed++;
        } else {
            System.out.println("Test Failed: customTotalRange");
        }
        total++;
        if (testGetTotalEqualsValue()) {
            System.out.println("Test Passed: getTotalEqualsValue");
            passed++;
        } else {
            System.out.println("Test Failed: getTotalEqualsValue");
        }
        total++;
        if (testRollChangesTotal()) {
            System.out.println("Test Passed: rollChangesTotal");
            passed++;
        } else {
            System.out.println("Test Failed: rollChangesTotal");
        }
        total++;
        if (testToStringFormat()) {
            System.out.println("Test Passed: toStringFormat");
            passed++;
        } else {
            System.out.println("Test Failed: toStringFormat");
        }

        System.out.println("Summary: " + passed + "/" + total + " tests passed.");
    }

    private static boolean testDefaultTotalRange() {
        PairOfDice p = new PairOfDice();
        int t = p.getTotal();
        return t >= 2 && t <= 12; // 2..6+6
    }

    private static boolean testCustomTotalRange() {
        int s = 20;
        PairOfDice p = new PairOfDice(s);
        int t = p.getTotal();
        return t >= 2 && t <= 2 * s;
    }

    private static boolean testGetTotalEqualsValue() {
        PairOfDice p = new PairOfDice();
        return p.getTotal() == p.value();
    }

    private static boolean testRollChangesTotal() {
        PairOfDice p = new PairOfDice();
        int first = p.getTotal();
        for (int i = 0; i < 10; i++) {
            p.roll();
            if (p.getTotal() != first)
                return true;
        }
        // It's possible (rare) that all rolls match the first; treat that as failure
        return false;
    }

    private static boolean testToStringFormat() {
        PairOfDice p = new PairOfDice();
        String s = p.toString();
        // Expect format: "<num> + <num> = <total>"
        try {
            String[] parts = s.split("=");
            if (parts.length != 2)
                return false;
            String rhs = parts[1].trim();
            int total = Integer.parseInt(rhs);
            String left = parts[0].trim(); // "a + b"
            String[] add = left.split("\\+");
            if (add.length != 2)
                return false;
            int a = Integer.parseInt(add[0].trim());
            int b = Integer.parseInt(add[1].trim());
            return a + b == total && total == p.getTotal();
        } catch (Exception ex) {
            return false;
        }
    }
}
