class Solution {
    int MAX = 10001;

    int cntCoprime(int[] arr) {
        int n = arr.length;
        int[] freq = new int[MAX];
        int[] cnt = new int[MAX];

        for (int val : arr) {
            freq[val]++;
        }

        for (int i = 1; i < MAX; i++) {
            for (int j = i; j < MAX; j += i) {
                cnt[i] += freq[j];
            }
        }

        int[] mobius = new int[MAX];
        Arrays.fill(mobius, 1);
        boolean[] isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i; j < MAX; j += i) {
                    mobius[j] *= -1;
                    isPrime[j] = false;
                }
                for (int j = i * i; j < MAX; j += i * i) {
                    mobius[j] = 0;
                }
            }
        }

        long res = 0;
        for (int d = 1; d < MAX; d++) {
            if (cnt[d] >= 2 && mobius[d] != 0) {
                long pairs = (long) cnt[d] * (cnt[d] - 1) / 2;
                res += mobius[d] * pairs;
            }
        }

        return (int) res;
    }
}
