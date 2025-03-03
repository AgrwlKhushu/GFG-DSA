//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int s = 0, e = 0;
        int ansStart = 0, ansEnd = 0;
        Deque<Integer> minDq = new LinkedList<>();
        Deque<Integer> maxDq = new LinkedList<>();
        while(e < arr.length){
            while(!minDq.isEmpty() && arr[minDq.peekLast()] > arr[e]) minDq.removeLast();
            while(!maxDq.isEmpty() && arr[maxDq.peekLast()] < arr[e]) maxDq.removeLast();
            
            minDq.addLast(e);
            maxDq.addLast(e);
            
            while(arr[maxDq.peekFirst()] - arr[minDq.peekFirst()] > x){
                if(s == maxDq.peekFirst()) maxDq.removeFirst();
                if(s == minDq.peekFirst()) minDq.removeFirst();
                s++;
            }
            if(e - s > ansEnd - ansStart){
                ansEnd = e;
                ansStart = s;
            }
            e++;
        }
        
        for(int i = ansStart; i <= ansEnd; i++){
            res.add(arr[i]);
        }
        return res;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends