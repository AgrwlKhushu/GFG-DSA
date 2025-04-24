//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSingle(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSingle(int[] arr) {
        // code here
        int[] bitCount = new int[32]; // To count bits for 32-bit integers
        
        // Count the number of times each bit appears
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                // Check if the ith bit is set
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        
        int result = 0;
        // Reconstruct the number that appears once
        for (int i = 0; i < 32; i++) {
            // If the count of the ith bit is not divisible by 3, set that bit in the result
            if (bitCount[i] % 3 != 0) {
                result |= (1 << i);
            }
        }
        
        return result;
    }
}