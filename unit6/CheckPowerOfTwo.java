package unit6;

/**
 * Check if Power of Two: Determine if a number is a power of 2 using bitwise operations.
 */
public class CheckPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 4, 8, 10, 16, 31, 32, 64, 100};
        for (int num : numbers) {
            System.out.println(num + " is power of 2? " + isPowerOfTwo(num));
        }
    }
}
