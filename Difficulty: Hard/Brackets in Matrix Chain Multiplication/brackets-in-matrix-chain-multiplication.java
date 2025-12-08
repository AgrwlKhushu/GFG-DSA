class Solution {
    public String matrixChainOrder(int arr[]) {
        // code here
        
        int n = arr.length;
        int m = n - 1;
        long[][] dp = new long[m][m];
        String[][] br = new String[m][m];
        for (int i = 0; i < m; i++) {
            br[i][i] = String.valueOf((char)('A' + i));
        }
        for (int len = 2; len <= m; len++) {
            for (int i = 0; i + len - 1 < m; i++) {
                int j = i + len - 1;
                dp[i][j] = Long.MAX_VALUE;
                String best = "";
                for (int k = i; k < j; k++) {
                    long cost = dp[i][k] + dp[k + 1][j] + 1L * arr[i] * arr[k + 1] * arr[j + 1];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        best = "(" + br[i][k] + br[k + 1][j] + ")";
                    }
                }
                br[i][j] = best;
            }
        }
        return br[0][m - 1];
    }
}