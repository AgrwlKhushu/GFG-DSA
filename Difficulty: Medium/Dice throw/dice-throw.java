class Solution {
    static int noOfWays(int m, int n, int x) {
        int[][] dp = new int[n + 1][x + 1];
        
        dp[0][0] = 1; // Base case
        
        for (int dice = 1; dice <= n; dice++) {
            for (int sum = 1; sum <= x; sum++) {
                dp[dice][sum] = 0;
                for (int face = 1; face <= m; face++) {
                    if (sum - face >= 0)
                        dp[dice][sum] += dp[dice - 1][sum - face];
                }
            }
        }
        
        return dp[n][x];
    }
}
