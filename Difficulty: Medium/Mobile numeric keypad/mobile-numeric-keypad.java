class Solution {
    public int getCount(int n) {
        if (n == 1) return 10;
        
        int[][] moves = {
            {0, 8},
            {1, 2, 4},
            {2, 1, 3, 5},
            {3, 2, 6},
            {4, 1, 5, 7},
            {5, 2, 4, 6, 8},
            {6, 3, 5, 9},
            {7, 4, 8},
            {8, 5, 7, 9, 0},
            {9, 6, 8}
        };
        
        int[][] dp = new int[10][n + 1];
        
        for (int i = 0; i <= 9; i++) {
            dp[i][1] = 1;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int digit = 0; digit <= 9; digit++) {
                dp[digit][len] = 0;
                for (int nei : moves[digit]) {
                    dp[digit][len] += dp[nei][len - 1];
                }
            }
        }
        
        int total = 0;
        for (int i = 0; i <= 9; i++) {
            total += dp[i][n];
        }
        
        return total;
    }
}
