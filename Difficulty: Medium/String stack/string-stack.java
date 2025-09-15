class Solution {
    public boolean stringStack(String pat, String tar) {
        // code here
        
        int n = pat.length(), m = tar.length();
        int i = n - 1, j = m - 1, skip = 0;
        while (i >= 0) {
            if (pat.charAt(i) == tar.charAt(j) && skip == 0) {
                i--;
                j--;
                if (j < 0) return true;
            } else {
                if (skip > 0) {
                    i--;
                    skip--;
                } else if (i >= 0 && pat.charAt(i) != tar.charAt(j)) {
                    i--;
                    skip++;
                }
            }
        }
        return j < 0;
    }
}
