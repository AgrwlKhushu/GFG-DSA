class Solution {
    private long getCost(int[] heights, int[] cost, int target) {
        long total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += (long) Math.abs(heights[i] - target) * cost[i];
        }
        return total;
    }
    
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int left = 0, right = 10000;
        
        while (right - left > 3) {
            int m1 = left + (right - left) / 3;
            int m2 = right - (right - left) / 3;
            
            long cost1 = getCost(heights, cost, m1);
            long cost2 = getCost(heights, cost, m2);
            
            if (cost1 < cost2) {
                right = m2;
            } else {
                left = m1;
            }
        }
        
        long minCost = Long.MAX_VALUE;
        for (int h = left; h <= right; h++) {
            minCost = Math.min(minCost, getCost(heights, cost, h));
        }
        
        return (int) minCost;
    }
}
