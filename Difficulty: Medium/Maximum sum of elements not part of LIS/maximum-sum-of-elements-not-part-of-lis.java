class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int total = 0;
        for (int num : arr) total += num;

        int[] dp = new int[n];
        int[] dpMinSum = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            dpMinSum[i] = arr[i];
        }

        int maxLIS = 1;
        int minLISsum = arr[0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    int currentLen = dp[j] + 1;
                    int currentSum = dpMinSum[j] + arr[i];

                    if (currentLen > dp[i]) {
                        dp[i] = currentLen;
                        dpMinSum[i] = currentSum;
                    } else if (currentLen == dp[i]) {
                        dpMinSum[i] = Math.min(dpMinSum[i], currentSum);
                    }
                }
            }

            if (dp[i] > maxLIS) {
                maxLIS = dp[i];
                minLISsum = dpMinSum[i];
            } else if (dp[i] == maxLIS) {
                minLISsum = Math.min(minLISsum, dpMinSum[i]);
            }
        }

        return total - minLISsum;
    }
}
