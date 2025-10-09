/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        traverse(root, ans);
        return ans;
    }

    private void traverse(Node node, ArrayList<Integer> ans) {
        if (node == null) return;
        traverse(node.left, ans);
        traverse(node.right, ans);
        ans.add(node.data);
    }
}