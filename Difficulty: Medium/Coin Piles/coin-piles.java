import java.util.*;

class Solution {
    public int minimumCoins(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        long[] prefix = new long[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int minRemoval = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int maxVal = x + k;

            int low = i, high = n - 1, j = i;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] <= maxVal) {
                    j = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            long removeLeft = (i > 0) ? prefix[i - 1] : 0;

            long removeRight = 0;
            if (j < n - 1) {
                long sumRight = prefix[n - 1] - prefix[j];
                removeRight = sumRight - (long)(n - 1 - j) * maxVal;
            }

            long totalRemoved = removeLeft + removeRight;
            minRemoval = (int) Math.min(minRemoval, totalRemoved);
        }

        return minRemoval;
    }
}
