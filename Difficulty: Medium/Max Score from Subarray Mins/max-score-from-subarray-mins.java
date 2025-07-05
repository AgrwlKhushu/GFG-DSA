class Solution {
    public int maxSum(int arr[]) {
        // code here
        
        int n = arr.length;
        int maxSum = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int sum = arr[i] + arr[i + 1];
            maxSum = Math.max(maxSum, sum);
        }
        
        for (int i = 0; i < n - 2; i++) {
            int[] temp = {arr[i], arr[i + 1], arr[i + 2]};
            Arrays.sort(temp);
            int sum = temp[0] + temp[1];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}