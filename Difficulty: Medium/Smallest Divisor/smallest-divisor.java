class Solution {
    public int smallestDivisor(int[] arr, int k) {
        int low = 1;
        int high = getMax(arr);

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (getSum(arr, mid) <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int getSum(int[] arr, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }
}
