//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());
            String input = br.readLine().trim();

            // Split the input line into integers and store them in the array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the getMinDiff method
            int res = ob.getMinDiff(k, arr);

            // Print the result
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int getMinDiff(int k, int[] arr) {
        // code here
        if (arr.length == 1) return 0;
        
        Arrays.sort(arr);
        int n = arr.length;
        
        // Initial difference
        int result = arr[n-1] - arr[0];
        
        // Try all possible combinations
        for (int i = 1; i < n; i++) {
            int max = Math.max(arr[i-1] + k, arr[n-1] - k);
            int min = Math.min(arr[0] + k, arr[i] - k);
            
            result = Math.min(result, max - min);
        }
        
        return result;
    }
}