class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        int xorVal = 0;
        for (int i = 1; i <= n; i++) {
            xorVal ^= i;
        }
        if (xorVal == n) {
            for (int i = 1; i <= n; i++) {
                ans.add(i);
            }
        } else {
            int x = xorVal ^ n;
            for (int i = 1; i <= n; i++) {
                if (i != x) ans.add(i);
            }
        }
        return ans;
    }
}
