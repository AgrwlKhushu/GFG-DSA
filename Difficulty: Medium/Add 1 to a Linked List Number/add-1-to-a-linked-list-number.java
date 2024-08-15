//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        Stack<Node> s = new Stack<>();
        Node temp = head;
       
        while(temp!=null){
            s.push(temp);
            temp = temp.next;
        }
        int carry = 1;
        if(s.peek().data<9){
            s.peek().data +=1;
        }else{
            while(!s.isEmpty()){
                Node cur = s.pop();
                int x = cur.data+carry;
                if(x>9){
                    cur.data = 0;
                    carry = 1;
                }else{
                    cur.data = x;
                    carry = 0;
                }
            }
            if(carry==1){
                Node n = new Node(carry);
                n.next = head;
                head = n;
            }
        }
        return head;
    }
}
