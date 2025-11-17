class Solution {
    public int maxSumIS(int arr[]) {
        // code here
        
        int n = arr.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}