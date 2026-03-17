package unit5;

public class FlipBitToWin {
    /**
     * You have an integer and you can flip exactly one bit from a 0 to a 1. 
     * Write code to find the length of the longest sequence of 1s you could create.
     */
    public static int longestSequence(int n) {
        /* If all 1s, this is already the longest sequence. */
        if (~n == 0) return Integer.SIZE;

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1; // We can always have at least one 1 by flipping a 0

        while (n != 0) {
            if ((n & 1) == 1) { // Current bit is a 1
                currentLength++;
            } else if ((n & 1) == 0) { // Current bit is a 0
                /* Update to 0 if next bit is 0 (can't merge), 
                 * or currentLength if next bit is 1. */
                previousLength = ((n & 2) == 0) ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            n >>>= 1;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] tests = {1775, -1, 0, 1, 7, 15, 21};
        for (int test : tests) {
            System.out.println(test + " (" + Integer.toBinaryString(test) + "): " + longestSequence(test));
        }
    }
}
