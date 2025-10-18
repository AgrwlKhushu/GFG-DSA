/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int findMedian(Node root) {
        int n = countNodes(root);
        int target = (n % 2 == 0) ? (n / 2) : ((n + 1) / 2);
        int[] result = new int[1];
        inorderFind(root, new int[]{0}, target, result);
        return result[0];
    }
    
    private int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private void inorderFind(Node root, int[] count, int target, int[] result) {
        if (root == null) return;
        inorderFind(root.left, count, target, result);
        count[0]++;
        if (count[0] == target) result[0] = root.data;
        inorderFind(root.right, count, target, result);
    }
}