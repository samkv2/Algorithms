package unit6;

/**
 * Primality Test: Check if a number is prime using optimized trial division.
 */
public class PrimalityTest {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 17, 19, 21, 25, 29, 31, 33, 97};
        for (int num : numbers) {
            System.out.println(num + " is prime? " + isPrime(num));
        }
    }
}
