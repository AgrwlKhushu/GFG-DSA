class Solution {
    public int maxProfit(int[][] jobs) {
        // code here
        
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));
        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int profit = jobs[i][2];
            int l = 0, r = i - 1, idx = -1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (jobs[m][1] <= jobs[i][0]) {
                    idx = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            if (idx != -1) profit += dp[idx];
            dp[i] = Math.max(dp[i - 1], profit);
        }
        return dp[n - 1];
    }
}
