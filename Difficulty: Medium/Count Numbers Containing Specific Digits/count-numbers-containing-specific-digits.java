class Solution {
    public int countValid(int n, int[] arr) {
        Set<Integer> allowed = new HashSet<>();
        for (int d : arr) allowed.add(d);

        int total = 9 * (int)Math.pow(10, n - 1);

        boolean[] forbiddenDigits = new boolean[10];
        for (int i = 0; i < 10; i++) {
            if (!allowed.contains(i)) {
                forbiddenDigits[i] = true;
            }
        }

        Map<String, Integer> memo = new HashMap<>();
        int invalid = countInvalidNumbers(n, 0, true, true, forbiddenDigits, memo);

        return total - invalid;
    }

    private int countInvalidNumbers(int n, int pos, boolean tight, boolean leadingZero,
                                    boolean[] forbiddenDigits, Map<String, Integer> memo) {
        if (pos == n) return leadingZero ? 0 : 1;

        String key = pos + "|" + tight + "|" + leadingZero;
        if (memo.containsKey(key)) return memo.get(key);

        int res = 0;
        int start = 0, end = 9;

        for (int digit = start; digit <= end; digit++) {
            if (!forbiddenDigits[digit]) continue;

            if (leadingZero && digit == 0) continue;

            res += countInvalidNumbers(n, pos + 1, false, false, forbiddenDigits, memo);
        }

        memo.put(key, res);
        return res;
    }
}
