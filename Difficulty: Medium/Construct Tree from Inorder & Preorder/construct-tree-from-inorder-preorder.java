//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    private static int preorderindex = 0;
    public static Node buildTree(int inorder[], int preorder[]) {
       preorderindex = 0;
       return mapbuild_helper(preorder, inorder, 0, inorder.length-1);
  
    }
    public static Node mapbuild_helper(int preorder[], int inorder[], int left, int right){
        if(left > right) return null;
        int rootval = preorder[preorderindex++];
        Node root = new Node(rootval);
        int rootindex  = inoderindex(rootval, inorder);
        root.left = mapbuild_helper(preorder, inorder, left, rootindex-1);
        root.right = mapbuild_helper(preorder, inorder, rootindex +1, right);
        return root;
    }
    public static int inoderindex (int rootval, int inorder[]){
        for(int i =0; i< inorder.length; i++){
            if(inorder[i] == rootval) return i;
        }
        return -1;
    }
}
