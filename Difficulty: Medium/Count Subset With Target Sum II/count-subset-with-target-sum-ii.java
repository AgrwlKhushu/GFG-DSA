class Solution {
    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        long[] left = generateSums(arr, 0, n / 2);
        long[] right = generateSums(arr, n / 2, n);
        java.util.Arrays.sort(right);
        
        long count = 0;
        for (long s : left) {
            long need = k - s;
            count += upperBound(right, need) - lowerBound(right, need);
        }
        return (int)count;
    }
    
    private long[] generateSums(int[] arr, int start, int end) {
        int len = end - start;
        long[] sums = new long[1 << len];
        for (int mask = 0; mask < (1 << len); mask++) {
            long sum = 0;
            for (int b = 0; b < len; b++) {
                if ((mask & (1 << b)) != 0) {
                    sum += arr[start + b];
                }
            }
            sums[mask] = sum;
        }
        return sums;
    }
    
    private int lowerBound(long[] arr, long val) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < val) l = m + 1;
            else r = m;
        }
        return l;
    }
    
    private int upperBound(long[] arr, long val) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= val) l = m + 1;
            else r = m;
        }
        return l;
    }
}
