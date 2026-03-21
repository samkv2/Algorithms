package unit6;

import java.math.BigInteger;

/**
 * Factorial: Compute the factorial of a number using recursion and BigInteger for large results.
 */
public class Factorial {
    public static BigInteger getFactorial(int n) {
        if (n < 0) return BigInteger.ZERO;
        if (n == 0 || n == 1) return BigInteger.ONE;
        
        return BigInteger.valueOf(n).multiply(getFactorial(n - 1));
    }

    public static BigInteger getFactorialIterative(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println("Factorial of " + n + " (Recursive): " + getFactorial(n));
        System.out.println("Factorial of " + n + " (Iterative): " + getFactorialIterative(n));
    }
}
