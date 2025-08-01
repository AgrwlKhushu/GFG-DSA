//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n = arr.length;
        int[][] newArr = new int[n][2];

        for (int i = 0; i < n; i++) {
            newArr[i][0] = arr[i];
            newArr[i][1] = dep[i];
        }

        // Sort based on arrival time
        Arrays.sort(newArr, (a, b) -> Integer.compare(a[0], b[0]));

        // Priority Queue (Min Heap) to store departure times
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add the first train's departure
        pq.add(newArr[0][1]);

        for (int i = 1; i < n; i++) {
            // If the current train arrives after the earliest departure, remove it
            if (newArr[i][0] > pq.peek()) {
                pq.poll();
            }
            pq.add(newArr[i][1]); // Add current train's departure
        }

        // The size of the priority queue will be the minimum number of platforms needed
        return pq.size();
    }
}
