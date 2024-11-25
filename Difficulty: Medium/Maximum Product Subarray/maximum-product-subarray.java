//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        if (arr.length == 0) return 0;

        // Initialize variables
        int max_ending_here = arr[0];
        int min_ending_here = arr[0];
        int max_so_far = arr[0];

        // Traverse the array from the second element
        for (int i = 1; i < arr.length; i++) {
            int temp = max_ending_here;

            // Update max and min ending here for the current element
            max_ending_here = Math.max(arr[i], Math.max(max_ending_here * arr[i], min_ending_here * arr[i]));
            min_ending_here = Math.min(arr[i], Math.min(temp * arr[i], min_ending_here * arr[i]));

            // Update the result
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }
}