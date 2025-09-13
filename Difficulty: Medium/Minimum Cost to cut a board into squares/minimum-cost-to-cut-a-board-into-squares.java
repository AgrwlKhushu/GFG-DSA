class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        // code here
        
        Arrays.sort(x);
        Arrays.sort(y);
        int i = x.length - 1, j = y.length - 1;
        int hSeg = 1, vSeg = 1;
        int cost = 0;
        while (i >= 0 && j >= 0) {
            if (x[i] > y[j]) {
                cost += x[i] * hSeg;
                vSeg++;
                i--;
            } else {
                cost += y[j] * vSeg;
                hSeg++;
                j--;
            }
        }
        while (i >= 0) {
            cost += x[i] * hSeg;
            vSeg++;
            i--;
        }
        while (j >= 0) {
            cost += y[j] * vSeg;
            hSeg++;
            j--;
        }
        return cost;
    }
}
