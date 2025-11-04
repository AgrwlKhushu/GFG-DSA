class Solution {
    int minCost(int[] height) {
        // code here
        
        int n = height.length;
        if (n == 1) return 0;
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int oneStep = prev + Math.abs(height[i] - height[i - 1]);
            int twoStep = Integer.MAX_VALUE;
            if (i > 1) twoStep = prev2 + Math.abs(height[i] - height[i - 2]);
            int cur = Math.min(oneStep, twoStep);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}