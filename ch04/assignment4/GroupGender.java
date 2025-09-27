package ch04.assignment4;

import ch04.queues.ArrayBoundedQueue;

public class GroupGender {

    private static final int MAX_NAMES_PER_GENDER = 10;
    private ArrayBoundedQueue<String> maleNames;
    private ArrayBoundedQueue<String> femaleNames;

    public GroupGender() {
        maleNames = new ArrayBoundedQueue<>(MAX_NAMES_PER_GENDER);
        femaleNames = new ArrayBoundedQueue<>(MAX_NAMES_PER_GENDER);
    }

    public boolean isMaleGender(String gender) {
        return gender.equalsIgnoreCase("M");
    }

    public boolean addPerson(String nameAndGender) {

        String[] parts = nameAndGender.split(" ", 2);

        String gender = parts[0];
        String name = parts[1];

        if (isMaleGender(gender)) {
            if (maleNames.isFull()) {
                return false;

            }
            maleNames.enqueue(name);
            return true;

        }

        if (femaleNames.isFull()) {
            return false;
        }
        femaleNames.enqueue(name);
        return true;

    }

    public String retrieveGenders() {
        StringBuilder sb = new StringBuilder("males: ");

        while (!maleNames.isEmpty()) {
            String name = maleNames.dequeue();
            sb.append(name).append(" ");
        }

        sb.append("females: ");
        while (!femaleNames.isEmpty()) {
            String name = femaleNames.dequeue();
            sb.append(name).append(" ");
        }

        return sb.toString();
    }
}