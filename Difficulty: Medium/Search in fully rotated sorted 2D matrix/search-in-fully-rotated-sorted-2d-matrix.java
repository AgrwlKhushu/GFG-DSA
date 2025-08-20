class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m, col = mid % m;
            int val = mat[row][col];

            if (val == x) return true;

            int lowVal = mat[low / m][low % m];
            int highVal = mat[high / m][high % m];

            // Left half is sorted
            if (lowVal <= val) {
                if (lowVal <= x && x < val) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (val < x && x <= highVal) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
