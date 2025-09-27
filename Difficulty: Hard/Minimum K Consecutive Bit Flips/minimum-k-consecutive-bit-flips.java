class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
        
        int n = arr.length;
        int[] isFlipped = new int[n];
        int result = 0, flip = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) flip ^= isFlipped[i - k];
            if ((arr[i] ^ flip) == 0) {
                if (i + k > n) return -1;
                result++;
                flip ^= 1;
                isFlipped[i] = 1;
            }
        }
        return result;
    }
}
