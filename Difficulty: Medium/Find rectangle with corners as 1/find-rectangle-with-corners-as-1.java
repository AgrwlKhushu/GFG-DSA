class Solution {
    public boolean ValidCorner(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                for (int col = 0; col < m; col++) {
                    if (mat[i][col] == 1 && mat[j][col] == 1) {
                        count++;
                        if (count >= 2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
