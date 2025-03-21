//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;

        if (n == 0) return 0;
        if (n == 1) return arr[0];

        // Set previous 2 values
        int secondLast = 0, last = arr[0];

        // Compute current value using previous
        // two values. The final current value
        // would be our result
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(arr[i] + secondLast, last);
            secondLast = last;
            last = res;
        }

        return res;
    }
}