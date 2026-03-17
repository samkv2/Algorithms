package unit5;

public class NextNumber {
    /**
     * Given a positive integer, print the next smallest and the next largest number 
     * that have the same number of 1 bits in their binary representation.
     */
    public static int getNext(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>>= 1;
        }
        while ((c & 1) == 1) {
            c1++;
            c >>>= 1;
        }

        /* Error: if n is 11..1100..00, then there is no bigger number with the same number of 1s. */
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }

        int p = c0 + c1; // position of rightmost non-trailing zero
        n |= (1 << p); // Flip rightmost non-trailing zero
        n &= ~((1 << p) - 1); // Clear all bits to the right of p
        n |= (1 << (c1 - 1)) - 1; // Insert (c1-1) ones on the right
        return n;
    }

    public static int getPrev(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1++;
            temp >>>= 1;
        }

        if (temp == 0) return -1;

        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>>= 1;
        }

        int p = c0 + c1; // position of rightmost non-trailing one
        n &= ((~0) << (p + 1)); // clears from bit p onwards
        int mask = (1 << (c1 + 1)) - 1; // sequence of (c1+1) ones
        n |= mask << (c0 - 1);
        return n;
    }

    public static void main(String[] args) {
        int n = 13948; // 11011001111100
        System.out.println("n:    " + n + " \t(" + Integer.toBinaryString(n) + ")");
        int next = getNext(n);
        System.out.println("Next: " + next + " \t(" + (next == -1 ? "N/A" : Integer.toBinaryString(next)) + ")");
        int prev = getPrev(n);
        System.out.println("Prev: " + prev + " \t(" + (prev == -1 ? "N/A" : Integer.toBinaryString(prev)) + ")");
    }
}
