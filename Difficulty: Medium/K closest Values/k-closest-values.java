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

import java.util.*;

class Solution {
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : b[0] - a[0]
        );
        
        inorder(root, target, k, maxHeap);
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] pair : maxHeap) ans.add(pair[1]);
        return ans;
    }
    
    private void inorder(Node root, int target, int k, PriorityQueue<int[]> heap) {
        if (root == null) return;
        
        inorder(root.left, target, k, heap);
        
        int diff = Math.abs(root.data - target);
        heap.offer(new int[]{diff, root.data});
        
        if (heap.size() > k) heap.poll();
        
        inorder(root.right, target, k, heap);
    }
}
