//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void reverse(int[] arr, int start, int end){
        // System.out.println("Start: " + start + " end: " + end);
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    void nextPermutation(int[] arr) {
        // code here
        // 1. find the largest indext k such that arr[k] < arr[k+1]
        int index = -1;
        
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] < arr[i+1]){
                index = i;
            }
        }
        
        if(index == -1){
            // it means given arr is largest permutation so sort the array
            reverse(arr, 0, arr.length-1);
            return;
        }
        else{
            // now to find the next permutation 
            // find the next elemnt which is greater than arr[index] and near to arr[index]
            int temp = index + 1;
            for(int i=index+2; i<arr.length; i++){
                if(arr[i] > arr[index]){
                    // temp = Math.min(arr[temp] - arr[index], arr[i] - arr[index]);
                    if(arr[temp]-arr[index] > arr[i]-arr[index]){
                        temp = i;
                    }
                }
            }
            
            // now swap the arr[temp] with arr[index]
            int temp2 = arr[index];
            arr[index] = arr[temp];
            arr[temp] = temp2;
            
            // System.out.println("index: " + index + " arr.length-1" + (arr.length-1));
            // now sort the remaining array from index+1 to arr.length
            reverse(arr, index+1, arr.length-1);
        }
    }

}