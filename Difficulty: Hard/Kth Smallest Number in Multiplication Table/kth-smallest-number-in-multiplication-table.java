class Solution {
    public int kthSmallest(int m, int n, int k) {
        int low = 1, high = m * n;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countLessEqual(mid, m, n) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    private int countLessEqual(int x, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, x / i);
        }
        return count;
    }
}
