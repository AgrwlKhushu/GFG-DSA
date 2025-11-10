class Solution {
    public int maxProfit(int arr[]) {
        // Code here
        
        int n = arr.length;
        if (n == 0) return 0;
        int[] hold = new int[n];
        int[] free = new int[n];
        hold[0] = -arr[0];
        free[0] = 0;
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], (i > 1 ? free[i - 2] : 0) - arr[i]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + arr[i]);
        }
        return free[n - 1];
    }
}
