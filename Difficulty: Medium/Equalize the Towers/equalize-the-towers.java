class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            pairs[i][0] = heights[i];
            pairs[i][1] = cost[i];
        }

        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        long totalWeight = 0;
        for (int i = 0; i < n; ++i) {
            totalWeight += pairs[i][1];
        }

        long currWeight = 0;
        int targetHeight = 0;
        for (int i = 0; i < n; ++i) {
            currWeight += pairs[i][1];
            if (currWeight >= (totalWeight + 1) / 2) {
                targetHeight = pairs[i][0];
                break;
            }
        }

        long totalCost = 0;
        for (int i = 0; i < n; ++i) {
            totalCost += 1L * cost[i] * Math.abs(heights[i] - targetHeight);
        }

        return (int)totalCost;
    }
}
