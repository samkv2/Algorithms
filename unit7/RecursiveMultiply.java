package unit7;

public class RecursiveMultiply {

    public static int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

    private static int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) return 0;
        if (smaller == 1) return bigger;

        int s = smaller >> 1; // Divide by 2
        int side1 = minProductHelper(s, bigger);
        int side2 = side1;
        if (smaller % 2 == 1) {
            side2 = side1 + bigger;
        }

        return side1 + side2;
    }

    // Optimized version with more bit shifting
    public static int minProductOptimized(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelperOptimized(smaller, bigger);
    }

    private static int minProductHelperOptimized(int smaller, int bigger) {
        if (smaller == 0) return 0;
        if (smaller == 1) return bigger;

        int s = smaller >> 1;
        int halfProd = minProductHelperOptimized(s, bigger);

        if (smaller % 2 == 0) {
            return halfProd << 1;
        } else {
            return (halfProd << 1) + bigger;
        }
    }

    public static void main(String[] args) {
        int a = 7;
        int b = 8;
        System.out.println(a + " * " + b + " = " + minProduct(a, b)); // Expected: 56
        System.out.println(a + " * " + b + " (Optimized) = " + minProductOptimized(a, b)); // Expected: 56

        a = 31;
        b = 35;
        System.out.println(a + " * " + b + " = " + minProduct(a, b)); // Expected: 1085
        System.out.println(a + " * " + b + " (Optimized) = " + minProductOptimized(a, b)); // Expected: 1085
    }
}
