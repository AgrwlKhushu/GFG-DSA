/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    private int sum = 0;

    public static void transformTree(Node root) {
        Solution sol = new Solution();
        sol.reverseInorder(root);
    }

    private void reverseInorder(Node root) {
        if (root == null) return;
        reverseInorder(root.right);

        int temp = root.data;
        root.data = sum;
        sum += temp;

        reverseInorder(root.left);
    }
}
