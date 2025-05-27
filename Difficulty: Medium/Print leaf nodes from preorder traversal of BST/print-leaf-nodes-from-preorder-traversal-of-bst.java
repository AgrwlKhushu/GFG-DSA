import java.util.*;

class Solution {
    int idx = 0;

    public ArrayList<Integer> leafNodes(int[] preorder) {
        ArrayList<Integer> result = new ArrayList<>();
        findLeaves(preorder, result, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return result;
    }

    private void findLeaves(int[] preorder, ArrayList<Integer> result, int min, int max) {
        if (idx >= preorder.length) return;

        int val = preorder[idx];

        if (val < min || val > max) return;

        idx++;

        int currentIdx = idx;

        findLeaves(preorder, result, min, val);    // Left Subtree
        findLeaves(preorder, result, val, max);    // Right Subtree

        if (idx == currentIdx) { // No children added → it's a leaf
            result.add(val);
        }
    }
}
