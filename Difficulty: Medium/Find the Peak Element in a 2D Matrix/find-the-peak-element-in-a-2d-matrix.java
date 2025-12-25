class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        // code here
        
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = mat[i][j];
                boolean ok = true;
                
                if (i > 0 && val < mat[i - 1][j]) ok = false;
                if (i + 1 < n && val < mat[i + 1][j]) ok = false;
                if (j > 0 && val < mat[i][j - 1]) ok = false;
                if (j + 1 < m && val < mat[i][j + 1]) ok = false;
                
                if (ok) {
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }
        
        ArrayList<Integer> fallback = new ArrayList<>();
        fallback.add(0);
        fallback.add(0);
        return fallback;
    }
}