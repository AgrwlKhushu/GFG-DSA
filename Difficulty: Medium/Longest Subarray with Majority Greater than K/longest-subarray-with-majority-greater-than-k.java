//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java
import java.util.*;

class Solution {
    static int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int[] trans = new int[n];
        
        for (int i = 0; i < n; i++) {
            trans[i] = (arr[i] > k) ? 1 : -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += trans[i];

            if (prefixSum > 0) {
                maxLen = i + 1;
            } else {
                if (map.containsKey(prefixSum - 1)) {
                    maxLen = Math.max(maxLen, i - map.get(prefixSum - 1));
                }
            }

            map.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int n = tokens.length;
            int[] arr = new int[n];

            int i = 0;
            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                arr[i] = Integer.parseInt(token);
                i++;
            }

            int k = Integer.parseInt(br.readLine().trim());
            System.out.println(new Solution().longestSubarray(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends