class Solution {
    int minCost(int[][] costs) {
        // code here
        
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        if (k == 0) return -1;
        if (k == 1) {
            if (n == 1) return costs[0][0];
            return -1;
        }
        
        int min1 = 0, min2 = 0, idx1 = -1;
        
        for (int i = 0; i < n; i++) {
            int nmin1 = Integer.MAX_VALUE;
            int nmin2 = Integer.MAX_VALUE;
            int nidx1 = -1;
            
            for (int c = 0; c < k; c++) {
                int cost = costs[i][c];
                int cur;
                if (c == idx1) cur = cost + min2;
                else cur = cost + min1;
                
                if (cur < nmin1) {
                    nmin2 = nmin1;
                    nmin1 = cur;
                    nidx1 = c;
                } else if (cur < nmin2) {
                    nmin2 = cur;
                }
            }
            
            min1 = nmin1;
            min2 = nmin2;
            idx1 = nidx1;
        }
        
        return min1 >= Integer.MAX_VALUE ? -1 : min1;
    }
}