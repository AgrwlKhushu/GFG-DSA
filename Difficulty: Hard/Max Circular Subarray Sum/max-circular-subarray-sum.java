//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int[] arr) {
    int n = arr.length;

    int maxNormal = kadane(arr);
    if (maxNormal < 0) {
        return maxNormal;
    }

    int arraySum = 0;
    for (int i = 0; i < n; i++) {
        arraySum += arr[i];
        arr[i] = -arr[i]; 
    }

    int minSubarraySum = kadane(arr);

    int maxCircular = arraySum + minSubarraySum; 

    return Math.max(maxNormal, maxCircular);
}

private int kadane(int[] arr) {
    int maxEndingHere = 0, maxSoFar = Integer.MIN_VALUE;
    for (int num : arr) {
        maxEndingHere = Math.max(num, maxEndingHere + num);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
}
}
