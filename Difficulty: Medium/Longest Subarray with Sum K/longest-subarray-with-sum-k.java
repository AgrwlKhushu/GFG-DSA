//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // HashMap to store the prefix sums and their first occurrences
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0; // Initialize prefix sum
        int maxLength = 0; // To store the maximum length of the subarray
        
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i]; // Update the running prefix sum
            
            // Check if the prefix sum is equal to k
            if (prefixSum == k) {
                maxLength = i + 1; // Subarray from start to current index
            }
            
            // Check if (prefixSum - k) exists in the map
            if (prefixSumMap.containsKey(prefixSum - k)) {
                // Calculate the length of the subarray
                maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum - k));
            }
            
            // Store the prefix sum in the map if it's not already present
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }
        
        return maxLength; // Return the maximum length found
    }
}