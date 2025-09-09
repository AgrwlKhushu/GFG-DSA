class Solution {
    public int assignHole(int[] mices, int[] holes) {
        // code here
        
        Arrays.sort(mices);
        Arrays.sort(holes);
        int n = mices.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.abs(mices[i] - holes[i]));
        }
        return ans;
    }
};