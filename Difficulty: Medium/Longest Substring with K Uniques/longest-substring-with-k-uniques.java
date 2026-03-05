class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        
        int n = s.length();
        int i = 0, j = 0;
        int cnt = 0;
        int maxi = -1;
        int[] fre = new int[26];

        while (j < n) {
            int r = s.charAt(j) - 'a';
            fre[r]++;
            if (fre[r] == 1) cnt++;

            while (cnt > k) {
                int l = s.charAt(i) - 'a';
                fre[l]--;
                if (fre[l] == 0) cnt--;
                i++;
            }

            if (cnt == k) {
                maxi = Math.max(maxi, j - i + 1);
            }

            j++;
        }

        return maxi;
    }
}