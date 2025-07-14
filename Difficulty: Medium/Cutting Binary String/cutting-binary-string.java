import java.util.*;

class Solution {
    public int cuts(String s) {
        Set<String> powerOfFive = new HashSet<>();
        
        long num = 1;
        while (num <= (1L << 30)) {
            powerOfFive.add(Long.toBinaryString(num));
            num *= 5;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                String sub = s.substring(j - 1, i);
                if (!sub.startsWith("0") && powerOfFive.contains(sub)) {
                    if (dp[j - 1] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
