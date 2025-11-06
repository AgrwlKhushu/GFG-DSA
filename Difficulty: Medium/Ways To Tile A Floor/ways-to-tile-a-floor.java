class Solution {
    public int numberOfWays(int n) {
        // code here
        
        if(n == 1) return 1;
        if(n == 2) return 2;
        int a = 1, b = 2;
        for(int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
};