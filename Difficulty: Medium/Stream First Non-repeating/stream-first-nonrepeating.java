class Solution {
    public String firstNonRepeating(String s) {
        // code here
        
        int[] firstIndex = new int[26];
        boolean[] isValid = new boolean[26];
        Arrays.fill(firstIndex, -1);
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (isValid[idx]) {
                firstIndex[idx] = -1;
            } else {
                firstIndex[idx] = i;
                isValid[idx] = true;
            }
            
            int minIdx = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {
                if (isValid[j] && firstIndex[j] != -1) {
                    minIdx = Math.min(minIdx, firstIndex[j]);
                }
            }
            
            if (minIdx == Integer.MAX_VALUE) {
                result.append('#');
            } else {
                result.append(s.charAt(minIdx));
            }
        }
        return result.toString();
    }
}