class Solution {
    public int minTime(int[] ranks, int n) {
        int m = ranks.length;
        int minRank = Integer.MAX_VALUE;
        for (int r : ranks) {
            if (r < minRank) minRank = r;
        }
        long low = 0;
        long high = (long) minRank * n * (n + 1) / 2;
        int ans = (int) high;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (canMake(ranks, n, mid)) {
                ans = (int) mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canMake(int[] ranks, int n, long time) {
        long total = 0;
        for (int r : ranks) {
            long t = time;
            long k = 0;
            long low = 0, high = n;
            while (low <= high) {
                long mid = (low + high) / 2;
                long need = r * mid * (mid + 1) / 2;
                if (need <= t) {
                    k = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            total += k;
            if (total >= n) return true;
        }
        return total >= n;
    }
}
