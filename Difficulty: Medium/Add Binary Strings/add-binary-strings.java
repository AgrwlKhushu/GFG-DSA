//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        if(s2.length() > s1.length()){
            return addBinary(s2 , s1);
        }
        int carry = 0;
        int i = s1.length() - 1 , j = s2.length() - 1;
        StringBuilder res = new StringBuilder();
        while(i >= 0 && j >= 0){
            int val1 = s1.charAt(i--) - '0';
            int val2 = s2.charAt(j--) - '0';
            int sum = carry + val1 + val2;
            res.append(sum % 2);
            carry = sum / 2;
        }
        while(i >= 0){
            int val1 = s1.charAt(i--) - '0';
            int sum = val1 + carry;
            res.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0){
            char ch = (char) (carry + '0');
            res.append(ch);
        }
        String result = res.reverse().toString();
        int idx = 0;
        while(idx < result.length() && result.charAt(idx) == '0'){
            idx++;
        }
        return result.substring(idx , result.length());
    }
}