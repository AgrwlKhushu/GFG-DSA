//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class TreeInfo {
    boolean isBST;
    int size;
    int min;
    int max;

    TreeInfo(boolean isBST, int size, int min, int max) {
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
    }
}

class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root){
     return largestBstHelper(root).size;
    }

    private static TreeInfo largestBstHelper(Node root) {
        // Base case: an empty tree is a BST of size 0
        if (root == null) {
            return new TreeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Recursively get info about the left and right subtrees
        TreeInfo leftInfo = largestBstHelper(root.left);
        TreeInfo rightInfo = largestBstHelper(root.right);

        // Check if the current tree is a BST
        if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max && root.data < rightInfo.min) {
            // Current tree is a BST
            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(root.data, leftInfo.min);
            int max = Math.max(root.data, rightInfo.max);
            return new TreeInfo(true, size, min, max);
        } else {
            // Current tree is not a BST
            return new TreeInfo(false, Math.max(leftInfo.size, rightInfo.size), 0, 0);
        }
    }
    
}