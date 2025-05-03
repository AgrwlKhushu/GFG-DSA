//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    int nearestPrime(int n) {
        if (isPrime(n)) {
            return n;
        }
        int left = n - 1;
        int right = n + 1;
        while (true) {
            boolean isLeftPrime = isPrime(left);
            boolean isRightPrime = isPrime(right);
            if (isLeftPrime && isRightPrime) {
                return Math.abs(n - left) <= Math.abs(n - right) ? left : right;
            } else if (isLeftPrime) {
                return left;
            } else if (isRightPrime) {
                return right;
            }
            left--;
            right++;
        }
    }
    Node primeList(Node head) {
        // code here
         Node current = head;
        while (current != null) {
            current.val = nearestPrime(current.val);
            current = current.next;
        }
        return head;
    }
}