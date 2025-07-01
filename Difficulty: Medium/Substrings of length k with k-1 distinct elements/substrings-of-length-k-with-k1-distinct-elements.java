class Solution {
    public int substrCount(String s, int k) {
        // code here
        
        if (k > s.length()) return 0;

        Map<Character, Integer> freq = new HashMap<>();
        int count = 0;

        for (int i = 0; i < k; i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (freq.size() == k - 1) count++;

        for (int i = k; i < s.length(); i++) {
            char leftChar = s.charAt(i - k);
            freq.put(leftChar, freq.get(leftChar) - 1);
            if (freq.get(leftChar) == 0) {
                freq.remove(leftChar);
            }

            char rightChar = s.charAt(i);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);

            if (freq.size() == k - 1) {
                count++;
            }
        }

        return count;
    }
}