class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res = new ArrayList<>();
        int[] curr = arr[0];
        res.add(curr);
        for (int i = 1; i < arr.length; i++) {
            int[] interval = arr[i];
            if (interval[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                curr = interval;
                res.add(curr);
            }
        }
        return res;
    }
}