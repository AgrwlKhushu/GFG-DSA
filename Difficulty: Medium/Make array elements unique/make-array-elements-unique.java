//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.minIncrements(a);
            System.out.println(A);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minIncrements(int[] arr) {
        // Code here
        int ans = 0;
        Arrays.sort(arr);
        int mini = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i] <= mini)
            {
                ans += mini + 1 - arr[i];
                mini = mini + 1;
            }
            else{
                mini = arr[i];
            }
            
        }
        return ans;
    }
}