class Solution {
    public int cntWays(int[] arr) {
        // code here
        
        int n = arr.length;
        int[] pe = new int[n];
        int[] po = new int[n];
        pe[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pe[i] = pe[i - 1];
            po[i] = po[i - 1];
            if (i % 2 == 0) pe[i] += arr[i];
            else po[i] += arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int leftEven = 0, leftOdd = 0;
            if (i > 0) {
                leftEven = pe[i - 1];
                leftOdd = po[i - 1];
            }
            int rightEven = pe[n - 1] - pe[i];
            int rightOdd = po[n - 1] - po[i];
            int evenSum = leftEven + rightOdd;
            int oddSum = leftOdd + rightEven;
            if (evenSum == oddSum) ans++;
        }
        return ans;
    }
}
