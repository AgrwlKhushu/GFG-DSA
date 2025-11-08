class Solution {
    public int numberOfPath(int[][] mat, int k) {
        // code here
        
        int n = mat.length, m = mat[0].length;
        Integer[][][] dp = new Integer[n][m][k + 1];
        return helper(mat, 0, 0, k, dp);
    }
    
    private int helper(int[][] mat, int i, int j, int k, Integer[][][] dp) {
        int n = mat.length, m = mat[0].length;
        if (i >= n || j >= m || k < 0) return 0;
        if (i == n - 1 && j == m - 1) return k == mat[i][j] ? 1 : 0;
        if (dp[i][j][k] != null) return dp[i][j][k];
        int remaining = k - mat[i][j];
        int down = helper(mat, i + 1, j, remaining, dp);
        int right = helper(mat, i, j + 1, remaining, dp);
        return dp[i][j][k] = down + right;
    }
}