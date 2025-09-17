package ch03.exercises;

public class Question10 {
    public static int binarySearch(int[] array, int target) {
        return binarySearchHelper(array, target, 0, array.length - 1);
    }

    private static int binarySearchHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // Target not found
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return binarySearchHelper(array, target, mid + 1, right);
        } else {
            return binarySearchHelper(array, target, left, mid - 1);
        }
    }
}
