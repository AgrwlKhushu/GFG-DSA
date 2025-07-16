class Solution {
    public static int countNumbers(int n) {
        int limit = (int)Math.sqrt(n) + 1;
        boolean[] isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < limit; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int count = 0;

        for (int p : primes) {
            long val = 1;
            for (int i = 0; i < 8; i++) val *= p;
            if (val <= n) count++;
            else break;
        }

        int size = primes.size();
        for (int i = 0; i < size; i++) {
            long p2 = (long)primes.get(i) * primes.get(i);
            if (p2 > n) break;
            for (int j = i + 1; j < size; j++) {
                long q2 = (long)primes.get(j) * primes.get(j);
                if (p2 * q2 <= n) count++;
                else break;
            }
        }

        return count;
    }
}
