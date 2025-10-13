/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    public int getMaxSum(Node root) {
        // code here
        
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] helper(Node node) {
        if (node == null) return new int[]{0, 0};
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int include = node.data + left[1] + right[1];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{include, exclude};
    }
}