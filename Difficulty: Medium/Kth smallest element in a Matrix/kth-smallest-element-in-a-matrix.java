class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int lo = mat[0][0];
        int hi = mat[0][n - 1];
        for (int i = 0; i < n; i++) {
            lo = Math.min(lo, mat[i][0]);
            hi = Math.max(hi, mat[i][n - 1]);
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = countLessEq(mat, mid);
            if (cnt >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int countLessEq(int[][] mat, int x) {
        int n = mat.length;
        int count = 0;
        int row = 0;
        int col = n - 1;
        while (row < n && col >= 0) {
            if (mat[row][col] <= x) {
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }
}
