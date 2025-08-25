class Solution {
    static boolean isPossible(int[] arr, int target, int k) {
        int n = arr.length;

        if (n % 2 == 1) {
            for (int i = n / 2; i < n; ++i) {
                if (arr[i] < target)
                    k -= (target - arr[i]);
                
                if(k < 0) break;
            }
        } else {
            if (arr[n / 2] <= target) {
                k -= (target - arr[n / 2]);
                k -= (target - arr[n / 2 - 1]);
            } else {
                k -= (2 * target - (arr[n / 2] + arr[n / 2 - 1]));
            }
            for (int i = n / 2 + 1; i < n; ++i) {
                if (arr[i] < target)
                    k -= (target - arr[i]);
                
                if(k < 0) break;
            }
        }

        return k >= 0;
    }

    static int maximizeMedian(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        int iniMedian = arr[n / 2];
        if (n % 2 == 0) {
            iniMedian += arr[n / 2 - 1];
            iniMedian /= 2;
        }

        int low = iniMedian, high = iniMedian + k;
        int bestMedian = iniMedian;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(arr, mid, k)) {
                bestMedian = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return bestMedian;
    }
}
