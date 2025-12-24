class Solution {
    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        int pivot = findPivot(arr, n);
        
        int count1 = 0;
        if (pivot > 0) {
            int low = 0, high = pivot - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] <= x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            count1 = low;
        }
        
        int count2 = 0;
        int low = pivot, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        count2 = low - pivot;
        
        return count1 + count2;
    }
    
    private int findPivot(int[] arr, int n) {
        if (n == 1) return 0;
        if (arr[0] <= arr[n - 1]) return 0;
        
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < n - 1 && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                return mid;
            }
            if (arr[mid] > arr[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}
