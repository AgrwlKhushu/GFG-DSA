class Solution {

    int lcmTriplets(int n) {
        long maxLCM = 0;

        for (int i = n; i >= Math.max(1, n - 4); i--) {
            for (int j = i; j >= Math.max(1, n - 4); j--) {
                for (int k = j; k >= Math.max(1, n - 4); k--) {
                    long l = lcm(lcm(i, j), k);
                    maxLCM = Math.max(maxLCM, l);
                }
            }
        }

        return (int) maxLCM;
    }

    // Helper function to calculate GCD
    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Helper function to calculate LCM
    long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
