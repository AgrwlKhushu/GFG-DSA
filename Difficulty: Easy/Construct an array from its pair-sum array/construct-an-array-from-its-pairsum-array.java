class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        // code here
        
        int m = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        if (m == 0) return ans;

        if (m == 1) {
            ans.add(1);
            ans.add(arr[0] - 1);
            return ans;
        }

        int n = 0;
        long k = 1;
        while (true) {
            long pairs = k * (k - 1) / 2;
            if (pairs == m) {
                n = (int) k;
                break;
            }
            k++;
        }

        long[] res = new long[n];
        long s01 = arr[0];
        long s02 = arr[1];
        long s12 = arr[n - 1];

        res[0] = (s01 + s02 - s12) / 2;
        for (int i = 1; i < n; i++) {
            res[i] = arr[i - 1] - res[0];
        }

        for (int i = 0; i < n; i++) {
            ans.add((int) res[i]);
        }
        return ans;
    }
}
