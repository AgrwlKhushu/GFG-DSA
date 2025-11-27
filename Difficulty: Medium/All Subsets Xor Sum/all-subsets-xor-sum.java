class Solution {
    int subsetXORSum(int arr[]) {
        // code here
        
        int n = arr.length;
        int bits = 0;
        for (int i = 0; i < n; i++) {
            bits |= arr[i];
        }
        return bits * (1 << (n - 1));
    }
}