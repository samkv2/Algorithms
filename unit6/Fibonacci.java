package unit6;

/**
 * Fibonacci Sequence: Compute Fibonacci numbers iteratively.
 */
public class Fibonacci {
    public static long getFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        long prev = 0;
        long current = 1;

        for (int i = 2; i <= n; i++) {
            long next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci sequence up to " + n + ":");
        for (int i = 0; i <= n; i++) {
            System.out.print(getFibonacci(i) + " ");
        }
        System.out.println();
    }
}
