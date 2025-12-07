class Solution {
    
    static final int MOD = 1000000007;
    
    int distinctSubseq(String str) {
        // code here
        
        int n = str.length();
        int[] dp = new int[n + 1];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (int)((2L * dp[i - 1]) % MOD);
            int idx = str.charAt(i - 1) - 'a';
            if (last[idx] != -1) {
                dp[i] = (dp[i] - dp[last[idx]] + MOD) % MOD;
            }
            last[idx] = i - 1;
        }
        return dp[n];
    }
}