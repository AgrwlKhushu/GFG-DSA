import java.util.*;

class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));

        // Step 1: Build suffix minimum array
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);
        }

        // Step 2: For each element, binary search farthest smaller to the right
        for (int i = 0; i < n; i++) {
            int lo = i + 1, hi = n - 1, ans = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (suffixMin[mid] < arr[i]) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            res.set(i, ans);
        }

        return res;
    }
}
