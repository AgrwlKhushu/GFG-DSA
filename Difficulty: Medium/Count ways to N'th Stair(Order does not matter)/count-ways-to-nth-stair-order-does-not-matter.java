//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int numberOfWays(int arr[],int st,int n){
        int dp[][] = new int[n+1][st+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=st;j++){
                if(i==0){
                    dp[i][j] = 0;
                    
                }
                if(j==0){
                    dp[i][j] = 1;
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1;j <=st;j ++){
                if(arr[i-1] <=j){
                    dp[i][j] = dp[i][j-arr[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][st];
    }
    public int nthStair(int n) {
        // Code here
        int arr[] = {1,2};
        
        return numberOfWays(arr,n,arr.length);
    }
}