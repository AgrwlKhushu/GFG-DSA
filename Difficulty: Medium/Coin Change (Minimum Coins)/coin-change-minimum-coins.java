//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int n = coins.length;
        int dp[] = new int[sum + 1];

        // Initialize dp array with a large value (infinity)
        // We use sum + 1 because it's impossible to need more than 'sum' coins
        for (int i = 1; i <= sum; i++) {
            dp[i] = sum + 1;
        }

        dp[0] = 0; // Base case: Zero coins needed to make sum 0

        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        // If dp[sum] is still sum + 1, it means sum cannot be formed with given coins
        return dp[sum] == sum + 1 ? -1 : dp[sum];
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
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
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends