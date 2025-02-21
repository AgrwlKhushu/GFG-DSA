//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            // Check if the character is an opening bracket
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {

                // If it's a closing bracket, check if the stack is non-empty
                // and if the top of the stack is a matching opening bracket
                if (!st.empty() && ((st.peek() == '(' && s.charAt(i) == ')') ||
                                    (st.peek() == '{' && s.charAt(i) == '}') ||
                                    (st.peek() == '[' && s.charAt(i) == ']'))) {
                    st.pop();
                } else {

                    // Unmatched closing bracket
                    return false;
                }
            }
        }

        // If stack is empty, return true (balanced),
        // otherwise false
        return st.empty();
    }
}
