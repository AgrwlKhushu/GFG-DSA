//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String removeDups(String str) {
        // code here
        Set<Character> set = new LinkedHashSet<>(); 
        char[] chars = str.toCharArray(); //convert string into char array
        for(char c : chars){
            set.add(c); //stores distinct elements only
        }
        
        StringBuilder string = new StringBuilder(); //store the unique characters in StringBuilder
        for(char c: set){
            string.append(c); 
        }
        return string.toString();
    }
}