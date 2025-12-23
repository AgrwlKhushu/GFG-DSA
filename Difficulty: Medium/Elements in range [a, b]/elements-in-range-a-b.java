import java.util.*;

class Solution {
    public ArrayList<Integer> cntInRange(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int a = q[0], b = q[1];
            int left = lowerBound(arr, a);
            int right = upperBound(arr, b);
            res.add(right - left);
        }
        return res;
    }
    
    private int lowerBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x) l = m + 1;
            else r = m;
        }
        return l;
    }
    
    private int upperBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= x) l = m + 1;
            else r = m;
        }
        return l;
    }
}
