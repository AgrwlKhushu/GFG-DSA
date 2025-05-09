//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    String max = "";

    public String findMaximumNum(String s, int k) {
        max = s;
        char[] arr = s.toCharArray();
        findMaxUtil(arr, k, 0);
        return max;
    }

    private void findMaxUtil(char[] arr, int k, int index) {
        if (k == 0 || index == arr.length) return;  // 🛑 Stop if no swaps left or index out of bounds

        char maxChar = arr[index];

        // Find the max digit from index to end
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > maxChar) {
                maxChar = arr[i];
            }
        }

        // Only proceed to swap if there's a better digit
        if (maxChar != arr[index]) k--;

        for (int i = arr.length - 1; i >= index; i--) {
            if (arr[i] == maxChar) {
                swap(arr, index, i);
                String curr = new String(arr);
                if (curr.compareTo(max) > 0) {
                    max = curr;
                }
                findMaxUtil(arr, k, index + 1);
                swap(arr, index, i); // backtrack
            }
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}