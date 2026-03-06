class Solution {
    public static String minWindow(String s, String p) {
        // code here
        
        int len1 = s.length();
        int len2 = p.length();
        
        if (len1 < len2) return "";
        
        int[] countP = new int[26];
        int[] countW = new int[26];
        
        for (int i = 0; i < len2; i++) {
            countP[p.charAt(i) - 'a']++;
        }
        
        int required = len2;
        int formed = 0;
        
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        while (right < len1) {
            char c = s.charAt(right);
            int idx = c - 'a';
            
            countW[idx]++;
            
            if (countP[idx] > 0 && countW[idx] <= countP[idx]) {
                formed++;
            }
            
            while (formed == required && left <= right) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                char d = s.charAt(left);
                int idy = d - 'a';
                countW[idy]--;
                
                if (countP[idy] > 0 && countW[idy] < countP[idy]) {
                    formed--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
