class Solution {
    public int minMen(int arr[]) {
        // code here
        
        int n = arr.length;
        java.util.List<int[]> range = new java.util.ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int left = Math.max(0, i - arr[i]);
                int right = Math.min(n - 1, i + arr[i]);
                range.add(new int[]{left, right});
            }
        }
        
        if (range.isEmpty()) return -1;
        
        range.sort((a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int men = 0, i = 0, maxi = -1;
        
        while (maxi < n - 1) {
            if (i >= range.size()) return -1;
            if (range.get(i)[0] > maxi + 1) return -1;
            
            int best = maxi;
            while (i < range.size() && range.get(i)[0] <= maxi + 1) {
                best = Math.max(best, range.get(i)[1]);
                i++;
            }
            
            men++;
            maxi = best;
        }
        
        return men;
    }
}