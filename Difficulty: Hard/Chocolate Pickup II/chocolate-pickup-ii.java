class Solution {
    public int chocolatePickup(int[][] mat) {
        // code here
        
        int n = mat.length;
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    dp[i][j][k] = Integer.MIN_VALUE;

        if (mat[0][0] == -1) return 0;
        dp[0][0][0] = mat[0][0];

        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < n; y1++) {
                for (int x2 = 0; x2 < n; x2++) {
                    int y2 = x1 + y1 - x2;
                    if (y2 < 0 || y2 >= n) continue;
                    if (mat[x1][y1] == -1 || mat[x2][y2] == -1) continue;

                    int val = mat[x1][y1];
                    if (x1 != x2 || y1 != y2) val += mat[x2][y2];

                    int best = Integer.MIN_VALUE;
                    if (x1 > 0 && x2 > 0) best = Math.max(best, dp[x1 - 1][y1][x2 - 1]);
                    if (x1 > 0 && y2 > 0) best = Math.max(best, dp[x1 - 1][y1][x2]);
                    if (y1 > 0 && x2 > 0) best = Math.max(best, dp[x1][y1 - 1][x2 - 1]);
                    if (y1 > 0 && y2 > 0) best = Math.max(best, dp[x1][y1 - 1][x2]);

                    if (best != Integer.MIN_VALUE)
                        dp[x1][y1][x2] = val + best;
                }
            }
        }

        int ans = dp[n - 1][n - 1][n - 1];
        return ans < 0 ? 0 : ans;
    }
}
