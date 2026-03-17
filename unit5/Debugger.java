package unit5;

public class Debugger {
    /**
     * Explain what the following code does: ((n & (n - 1)) == 0)
     * 
     * Breakdown:
     * n & (n - 1) clears the least significant bit that is set to 1.
     * If n is a power of 2, it has exactly one bit set to 1.
     * Clearing that bit results in 0.
     * Thus, ((n & (n - 1)) == 0) checks if n is a power of 2 (or if n is 0).
     */
    public static boolean isPowerOfTwoOrZero(int n) {
        return ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        int[] tests = {0, 1, 2, 3, 4, 5, 8, 15, 16};
        System.out.println("Testing ((n & (n-1)) == 0):");
        for (int n : tests) {
            System.out.println(n + " \t binary: " + Integer.toBinaryString(n) + " \t result: " + isPowerOfTwoOrZero(n));
        }
    }
}
