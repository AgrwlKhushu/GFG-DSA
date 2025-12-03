class Solution {
    int n;
    int[][] dp;
    
    public int tsp(int[][] cost) {
        n = cost.length;
        int maxMask = 1 << n;
        dp = new int[maxMask][n];
        for (int i = 0; i < maxMask; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(1, 0, cost);
    }
    
    private int solve(int mask, int pos, int[][] cost) {
        if (mask == (1 << n) - 1) {
            return cost[pos][0];
        }
        if (dp[mask][pos] != -1) return dp[mask][pos];
        
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int nextMask = mask | (1 << city);
                int curr = cost[pos][city] + solve(nextMask, city, cost);
                if (curr < ans) ans = curr;
            }
        }
        dp[mask][pos] = ans;
        return ans;
    }
}
