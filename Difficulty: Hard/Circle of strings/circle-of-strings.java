//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int isCircle(String arr[]) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<26; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];
        
        for(String str : arr) {
            int firstChar = str.charAt(0) - 'a';
            int lastChar = str.charAt(str.length() - 1) - 'a';
            
            adj.get(firstChar).add(lastChar);
            
            inDegree[firstChar]++;
            outDegree[lastChar]++;
        }
        
        for(int i=0; i<26; i++) {
            if(inDegree[i] != outDegree[i]) {
                return 0;
            }
        }
        
        boolean[] visit = new boolean[26];
        dfs(adj, arr[0].charAt(0) - 'a', visit, inDegree, outDegree);
        
        for(int i=0; i<26; i++) {
            if(inDegree[i] > 0 || 0 < outDegree[i]) {
                return 0;
            }
        }
        
        return 1;
    }
    
    public void dfs(List<List<Integer>> adj, int start, boolean[] visit, int[] inDegree, int[] outDegree) {
        visit[start] = true;
        
        for(int ch : adj.get(start)) {
            inDegree[start]--;
            outDegree[ch]--;
            
            if(!visit[ch]) {
                dfs(adj, ch, visit, inDegree, outDegree);
            }
        }
    }
}