//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    static int mod = (int)1e9+7;
    public static int countgroup(int arr[]) {
        // Complete the function
        int xor = 0;
        for(int a: arr)
        xor ^= a;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        int res = (solve(xor, 0, 0, arr, dp) / 2 - 1) % mod;
        return res < 0 ? 0 : res;
    }
    public static int solve(int xor, int val, int cur, int[] arr, int[] dp){
        if(cur >= arr.length){
            //  System.out.println(xor+" "+val);
            if(xor == val){
                // System.out.println(l);
                return 1;
            }
            return 0;
        }
        if(dp[cur] != -1)
            return dp[cur];
            
        int take = 0, nottake = 0;
        // l.add(arr[cur]);
        take = solve(xor^arr[cur], val^arr[cur], cur + 1, arr, dp) % mod;
        // l.remove(l.size()-1);
        nottake = solve(xor, val, cur + 1, arr, dp) % mod;
        return dp[cur] = (take + nottake) % mod;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int ans = obj.countgroup(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends