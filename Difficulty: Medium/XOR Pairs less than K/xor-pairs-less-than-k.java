class Solution {
    
    static class Node {
        Node[] child = new Node[2];
        int cnt;
    }
    
    public int cntPairs(int[] arr, int k) {
        // code here
        
        if (arr == null || arr.length < 2) return 0;
        Node root = new Node();
        int maxVal = k;
        for (int x : arr) maxVal = Math.max(maxVal, x);
        int maxBit = 0;
        while ((1 << maxBit) <= maxVal) maxBit++;
        int ans = 0;
        for (int x : arr) {
            ans += countLess(root, x, k, maxBit - 1);
            insert(root, x, maxBit - 1);
        }
        return ans;
    }
    
    private void insert(Node root, int num, int bit) {
        Node cur = root;
        for (int i = bit; i >= 0; i--) {
            int b = (num >> i) & 1;
            if (cur.child[b] == null) cur.child[b] = new Node();
            cur = cur.child[b];
            cur.cnt++;
        }
    }
    
    private int countLess(Node root, int num, int k, int bit) {
        Node cur = root;
        int res = 0;
        for (int i = bit; i >= 0 && cur != null; i--) {
            int nb = (num >> i) & 1;
            int kb = (k >> i) & 1;
            if (kb == 1) {
                if (cur.child[nb] != null) res += cur.child[nb].cnt;
                cur = cur.child[nb ^ 1];
            } else {
                cur = cur.child[nb];
            }
        }
        return res;
    }
}
