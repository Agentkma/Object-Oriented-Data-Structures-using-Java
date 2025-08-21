package ch01.apps.exercises;

public class PairOfDiceTest {
    public static void main(String[] args) {
        int passed = 0;
        int total = 0;

        total++;
        if (testNotRolledOnInit()) {
            System.out.println("Test Passed: notRolledOnInit");
            passed++;
        } else {
            System.out.println("Test Failed: notRolledOnInit");
        }

        total++;
        if (testRollProducesValidRange()) {
            System.out.println("Test Passed: rollProducesValidRange");
            passed++;
        } else {
            System.out.println("Test Failed: rollProducesValidRange");
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

    private static boolean testNotRolledOnInit() {
        PairOfDice p = new PairOfDice();
        // Since we do not roll on initialization, total should be 0
        return p.getTotal() == 0 && p.value() == 0;
    }

    private static boolean testRollProducesValidRange() {
        PairOfDice p = new PairOfDice();
        p.roll();
        int t = p.getTotal();
        return t >= 2 && t <= 12; // 2..6+6 for default 6 sides
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
        // Since we do not roll on init, expect "0 + 0 = 0"
        if (!"0 + 0 = 0".equals(s))
            return false;
        // Also verify parsing is consistent
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
