class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        
        int n = s1.length();
        int m = s2.length();
        
        if (m == 0) return "";
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    if (j == 1) {
                        dp[i][j] = i;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        int startIndex = 0;
        int minLength = n + 1;
        
        for (int i = 1; i <= n; i++) {
            if (s1.charAt(i - 1) == s2.charAt(m - 1) && dp[i][m] > 0) {
                int windowStart = dp[i][m] - 1;
                int windowLength = i - windowStart;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    startIndex = windowStart;
                }
            }
        }
        
        return minLength > n ? "" : s1.substring(startIndex, startIndex + minLength);
    }
}
