//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        // Complete the function
        StringBuffer res = new StringBuffer(str);
        int len = res.length();
        char last_digit = res.charAt(len - 1);
        if (last_digit == '0')
            return res.toString();
        if (last_digit <= '5'){
            res.setCharAt(len - 1, '0');
            return res.toString();
        }
        res.setCharAt(len - 1, '0');
        int carry = 1;
        for (int i = len - 2; i>=0; i--){
            char digit = res.charAt(i);
            if (digit == '9'){
                res.setCharAt(i, '0');
            }
            else{
                res.setCharAt(i, (char)(digit + 1));
                carry--;
                break;
            }
        }
        if (carry == 1)
            res.insert(0, '1');
        return res.toString();
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends