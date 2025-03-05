//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            Solution obj = new Solution();
            int res = obj.longestStringChain(words);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int longestStringChain(String words[]) {
        // code here
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // HashMap to store the longest chain ending at each word
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 1; // Minimum chain length is 1 (single word itself)

        for (String word : words) {
            int bestChain = 1; // Default length if no predecessor is found
            
            // Try removing each character to check for a predecessor
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(predecessor)) {
                    bestChain = Math.max(bestChain, dp.get(predecessor) + 1);
                }
            }

            dp.put(word, bestChain);
            maxLength = Math.max(maxLength, bestChain); // Update max chain length
        }
        
        return maxLength;
    }
}