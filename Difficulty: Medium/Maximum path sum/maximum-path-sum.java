/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int maxSum = Integer.MIN_VALUE;
    
    int findMaxSum(Node root) {
        // code here
        
        maxPathDown(root);
        return maxSum;
    }
    
    int maxPathDown(Node node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        int localMax = node.data + left + right;
        maxSum = Math.max(maxSum, localMax);
        return node.data + Math.max(left, right);
    }
}