/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int preIndex = 0;
    public Node constructTree(int[] pre, int[] post) {
        return build(pre, post, 0, post.length - 1);
    }

    private Node build(int[] pre, int[] post, int l, int r) {
        if (preIndex >= pre.length || l > r) return null;
        Node root = new Node(pre[preIndex++]);
        if (l == r || preIndex >= pre.length) return root;
        int idx = l;
        while (idx <= r && post[idx] != pre[preIndex]) idx++;
        if (idx <= r) {
            root.left = build(pre, post, l, idx);
            root.right = build(pre, post, idx + 1, r - 1);
        }
        return root;
    }
}