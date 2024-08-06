//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Split the string by dot (.)
        String[] parts = str.split("\\.");
        
        // There must be exactly 4 parts
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            // Each part must be a valid integer
            if (!isNumeric(part)) {
                return false;
            }
            
            int num = Integer.parseInt(part);

            // Each part must be between 0 and 255
            if (num < 0 || num > 255) {
                return false;
            }

            // Leading zeros are not allowed
            if (part.length() > 1 && part.charAt(0) == '0') {
                return false;
            }
        }

        return true;
    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}