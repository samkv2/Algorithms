package unit7;

public class MagicIndex {

    public static int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    private static int magicFast(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }
    }

    // Follow-up: Elements are not distinct
    public static int magicFastNonDistinct(int[] array) {
        return magicFastNonDistinct(array, 0, array.length - 1);
    }

    private static int magicFastNonDistinct(int[] array, int start, int end) {
        if (end < start) return -1;

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];

        if (midValue == midIndex) return midIndex;

        // Search left
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFastNonDistinct(array, start, leftIndex);
        if (left >= 0) return left;

        // Search right
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFastNonDistinct(array, rightIndex, end);
        
        return right;
    }

    public static void main(String[] args) {
        int[] sortedArray = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println("Magic Index: " + magicFast(sortedArray)); // Expected: 7 (array[7] = 7)

        int[] nonDistinctArray = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println("Magic Index (Non-distinct): " + magicFastNonDistinct(nonDistinctArray)); // Expected: 2
    }
}
