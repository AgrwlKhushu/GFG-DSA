//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    private static int solve(int i, int j, int[] nums, int[][] dp) {
        if(i == j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int steps = nums[i-1] * nums[k] * nums[j] + solve(i, k, nums, dp)
            + solve(k+1, j, nums, dp);
            min = Math.min(min, steps);
        }
        return dp[i][j] =  min;
    }
    static int matrixMultiplication(int arr[]) {
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] A : dp) {
            Arrays.fill(A, -1);
        }
        return solve(1, arr.length-1, arr, dp);
    }
}