class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;
        
        if ((long)m * k > n) return -1;
        
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int num : arr) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(arr, k, m, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean canMakeBouquets(int[] arr, int k, int m, int day) {
        int bouquets = 0, count = 0;
        
        for (int bloom : arr) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
            if (bouquets >= m) return true;
        }
        
        return false;
    }
}
