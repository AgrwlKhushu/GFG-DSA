//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int map=0;
        int i=0;
        int j=0;
        int ans=0;
        int n=s.length();
        while(j<n){
            char c=s.charAt(j);
            if((map&(1<<c-'a'))!=0){
                while(s.charAt(i)!=c){
                    char t=s.charAt(i);
                    i++;
                    map=map&(~(1<<t-'a'));
                }
                map=map&(~(1<<c-'a'));
                i++;
            }
             
            map=(map|(1<<c-'a')); 
            ans=Math.max(ans,(j-i+1));
            j++;
            
        }
        return ans;
    }
}