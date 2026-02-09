class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        
        int n = arr.length;
        int l = 0, r = n - 1;
        if (arr[l] <= arr[r]) return 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] > arr[(m + 1) % n]) return (m + 1) % n;
            if (arr[m] >= arr[l]) l = m + 1;
            else r = m - 1;
        }
        return 0;
    }
}