//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int i = 0, j = n - 1;
        while(i < j){
            if(mat[i][j] == 1){
                i++;
            }
            else j--;
        }
        
        int pot = i;
        
        for(int k = 0; k < n; k++){
            if(k != pot){
                if(mat[pot][k] == 1 || mat[k][pot] == 0) {
                    return -1;
                }
            }
        }
        return pot;
    }
}