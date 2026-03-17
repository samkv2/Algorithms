package unit5;

public class PairwiseSwap {
    /**
     * Write a program to swap odd and even bits in an integer with as few instructions 
     * as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
     */
    public static int swapOddEvenBits(int n) {
        /* 0xAAAAAAAA is 10101010... in binary (even bits if 0-indexed)
         * 0x55555555 is 01010101... in binary (odd bits if 0-indexed)
         * Shift logical right to avoid sign extension. */
        return (((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1));
    }

    public static void main(String[] args) {
        int n = 23; // 10111 -> 01111 (15)
        System.out.println("n:       " + n + " \t(" + Integer.toBinaryString(n) + ")");
        int swapped = swapOddEvenBits(n);
        System.out.println("Swapped: " + swapped + " \t(" + Integer.toBinaryString(swapped) + ")");
        
        int n2 = 10; // 1010 -> 0101 (5)
        System.out.println("n:       " + n2 + " \t(" + Integer.toBinaryString(n2) + ")");
        System.out.println("Swapped: " + swapOddEvenBits(n2) + " \t(" + Integer.toBinaryString(swapOddEvenBits(n2)) + ")");
    }
}
