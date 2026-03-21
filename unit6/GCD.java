package unit6;

/**
 * Greatest Common Divisor (GCD): Find the GCD using the Euclidean Algorithm.
 */
public class GCD {
    public static int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }

    public static int findGCDIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 48, b = 18;
        System.out.println("GCD of " + a + " and " + b + " is: " + findGCD(a, b));
        System.out.println("GCD of " + a + " and " + b + " (Iterative) is: " + findGCDIterative(a, b));
    }
}
