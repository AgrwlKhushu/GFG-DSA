class Solution {
    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactors = getPrimeFactors(k);
        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int exponentInK = entry.getValue();

            int powerInFactorial = 0;
            int tempN = n;
            while (tempN > 0) {
                tempN /= prime;
                powerInFactorial += tempN;
            }

            result = Math.min(result, powerInFactorial / exponentInK);
        }

        return result;
    }

    private Map<Integer, Integer> getPrimeFactors(int k) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            factors.put(k, 1);
        }
        return factors;
    }
}
