class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";
        int[] need = new int[128];
        for (char c : p.toCharArray()) need[c]++;
        int required = p.length();
        int left = 0, minLen = Integer.MAX_VALUE, start = 0;
        for (int right = 0; right < s.length(); right++) {
            if (need[s.charAt(right)] > 0) required--;
            need[s.charAt(right)]--;
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                need[s.charAt(left)]++;
                if (need[s.charAt(left)] > 0) required++;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
