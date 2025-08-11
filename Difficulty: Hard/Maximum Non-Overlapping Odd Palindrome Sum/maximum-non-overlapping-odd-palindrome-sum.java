import java.util.*;

class Solution {
    public int maxSum(String s) {
        int n = s.length();
        int[] d1 = new int[n];
        int l = 0, r = -1;
        for (int i = 0; i < n; i++) {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k)) k++;
            d1[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }

        SegTree segEnd = new SegTree(n);
        SegTree segStart = new SegTree(n);

        for (int c = 0; c < n; c++) {
            int k = d1[c];
            segEnd.updateRange(c, c + k - 1, -2 * c + 1);
            segStart.updateRange(c - k + 1, c, 2 * c + 1);
        }

        int[] maxEndAt = new int[n];
        int[] maxStartAt = new int[n];

        for (int i = 0; i < n; i++) {
            int bestB = segEnd.queryPoint(i);
            maxEndAt[i] = bestB == Integer.MIN_VALUE ? 0 : 2 * i + bestB;
            int bestC = segStart.queryPoint(i);
            maxStartAt[i] = bestC == Integer.MIN_VALUE ? 0 : -2 * i + bestC;
        }

        int[] prefMax = new int[n];
        prefMax[0] = maxEndAt[0];
        for (int i = 1; i < n; i++) prefMax[i] = Math.max(prefMax[i - 1], maxEndAt[i]);

        int[] sufMax = new int[n];
        sufMax[n - 1] = maxStartAt[n - 1];
        for (int i = n - 2; i >= 0; i--) sufMax[i] = Math.max(sufMax[i + 1], maxStartAt[i]);

        int ans = 0;
        for (int pos = 0; pos < n - 1; pos++) ans = Math.max(ans, prefMax[pos] + sufMax[pos + 1]);
        return ans;
    }

    private static class SegTree {
        int n;
        int[] tree;
        SegTree(int n) {
            this.n = n;
            tree = new int[4 * Math.max(1, n)];
            Arrays.fill(tree, Integer.MIN_VALUE);
        }
        void updateRange(int l, int r, int val) {
            if (l < 0) l = 0;
            if (r >= n) r = n - 1;
            if (l > r) return;
            update(1, 0, n - 1, l, r, val);
        }
        private void update(int node, int L, int R, int l, int r, int val) {
            if (l > R || r < L) return;
            if (l <= L && R <= r) {
                tree[node] = Math.max(tree[node], val);
                return;
            }
            int mid = (L + R) >> 1;
            update(node << 1, L, mid, l, r, val);
            update(node << 1 | 1, mid + 1, R, l, r, val);
        }
        int queryPoint(int idx) {
            return query(1, 0, n - 1, idx, Integer.MIN_VALUE);
        }
        private int query(int node, int L, int R, int idx, int cur) {
            cur = Math.max(cur, tree[node]);
            if (L == R) return cur;
            int mid = (L + R) >> 1;
            if (idx <= mid) return query(node << 1, L, mid, idx, cur);
            else return query(node << 1 | 1, mid + 1, R, idx, cur);
        }
    }
}
