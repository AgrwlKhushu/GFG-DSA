class Solution {
    public static int countSetBits(int n) {
        // code here
        
        if (n == 0) return 0;
        int x = (int)(Math.log(n) / Math.log(2));
        int bitsTill2x = x * (1 << (x - 1));
        int msbBits = n - (1 << x) + 1;
        int remaining = n - (1 << x);
        return bitsTill2x + msbBits + countSetBits(remaining);
    }
}