//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the array line and convert to int[]
            String input = br.readLine().trim();
            String[] tokens = input.split("\\s+");
            int n = tokens.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Read a, b, c from separate lines
            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());
            int c = Integer.parseInt(br.readLine().trim());

            // Call the solution method
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.sortArray(arr, a, b, c);

            // Output the result
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        long[] result = new long[n];

        int i = 0, j = n - 1;
        int index = A >= 0 ? n - 1 : 0;

        while (i <= j) {
            long val1 = transform(arr[i], A, B, C);
            long val2 = transform(arr[j], A, B, C);

            if (A >= 0) {
                if (val1 > val2) {
                    result[index--] = val1;
                    i++;
                } else {
                    result[index--] = val2;
                    j--;
                }
            } else {
                if (val1 < val2) {
                    result[index++] = val1;
                    i++;
                } else {
                    result[index++] = val2;
                    j--;
                }
            }
        }

        ArrayList<Integer> finalResult = new ArrayList<>(n);
        for (long val : result) {
            finalResult.add((int) val); // Guaranteed safe within constraints
        }

        return finalResult;
    }

    private long transform(int x, int A, int B, int C) {
        return 1L * A * x * x + 1L * B * x + C;
    }
}

