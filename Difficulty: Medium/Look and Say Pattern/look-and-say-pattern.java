//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.countAndSay(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String prev = "1";
        
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char currChar = prev.charAt(0);
            
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == currChar) {
                    count++;
                } else {
                    sb.append(count).append(currChar);
                    currChar = prev.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(currChar);
            prev = sb.toString();
        }
        
        return prev;
    }
}

