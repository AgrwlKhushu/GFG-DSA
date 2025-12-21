class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];
            
            int left = lowerBound(arr, l, r, x);
            int right = upperBound(arr, l, r, x);
            
            if (left == -1 || right == -1) ans.add(0);
            else ans.add(right - left + 1);
        }
        
        return ans;
    }
    
    private int lowerBound(int[] arr, int l, int r, int x) {
        int ans = -1;
        int low = l, high = r;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                if (arr[mid] == x) ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    private int upperBound(int[] arr, int l, int r, int x) {
        int ans = -1;
        int low = l, high = r;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                if (arr[mid] == x) ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}