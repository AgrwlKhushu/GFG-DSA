/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    public int findMaxFork(Node root, int k) {
        // code here.
        
        int res = -1; // use -1 or any sentinel if no value <= k exists

        while (root != null) {
            if (root.data <= k) {
                res = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return res;
    }
}