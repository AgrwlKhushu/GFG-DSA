class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        int n = mat1.length;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                set.add(x - mat1[i][j]);
            }
        }
        
        int cnt = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(set.contains(mat2[i][j])){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}