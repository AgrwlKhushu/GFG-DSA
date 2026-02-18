class Solution {
    static int inversionCount(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n];
        return (int)_mergeSort(arr, temp, 0, n - 1);
    }
    
    static long _mergeSort(int arr[], int temp[], int left, int right) {
        long inv_count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            inv_count += _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid + 1, right);
            inv_count += merge(arr, temp, left, mid, right);
        }
        return inv_count;
    }
    
    static long merge(int arr[], int temp[], int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long inv_count = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inv_count += (mid - i + 1);
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
        
        return inv_count;
    }
}
