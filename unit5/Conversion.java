package unit5;

public class Conversion {
    /**
     * Write a function to determine the number of bits you would need to flip 
     * to convert integer A to integer B.
     */
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        /* XOR gives bits that are different. 
         * Then count the number of set bits in (a ^ b). */
        for (int c = a ^ b; c != 0; c &= (c - 1)) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 29; // 11101
        int b = 15; // 01111
        System.out.println("A: " + a + " (" + Integer.toBinaryString(a) + ")");
        System.out.println("B: " + b + " (" + Integer.toBinaryString(b) + ")");
        System.out.println("Bits to flip: " + bitSwapRequired(a, b));
    }
}
