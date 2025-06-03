// User function Template for Java

import java.util.*;

class Solution {
    public int countSubstr(String s, int k) {
        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    private int countAtMostKDistinct(String s, int k) {
        if (k == 0) return 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0, count = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }

            count += (right - left + 1);
            right++;
        }

        return count;
    }
}
