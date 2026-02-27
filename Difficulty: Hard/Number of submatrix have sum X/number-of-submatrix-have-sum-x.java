class Solution {
    public int countSquare(int[][] mat, int x) {
        // code here
        
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        int maxSize = Math.min(n, m);
        for (int size = 1; size <= maxSize; size++) {
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    int sum = 0;
                    for (int p = i; p < i + size; p++) {
                        for (int q = j; q < j + size; q++) {
                            sum += mat[p][q];
                        }
                    }
                    if (sum == x) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}