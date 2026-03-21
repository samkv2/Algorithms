package unit6;

import java.util.ArrayList;
import java.util.List;

/**
 * Sieve of Eratosthenes: Efficiently find all prime numbers up to a given limit.
 */
public class SieveOfEratosthenes {
    public static List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        int limit = 50;
        List<Integer> primes = sieve(limit);
        System.out.println("Primes up to " + limit + ": " + primes);
    }
}
