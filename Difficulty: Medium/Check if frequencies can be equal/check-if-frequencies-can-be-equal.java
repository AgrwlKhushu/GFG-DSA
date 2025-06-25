class Solution {
    boolean sameFreq(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int f : freq.values()) {
            freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);
        }

        if (freqCount.size() == 1) {
            return true; 
        } else if (freqCount.size() == 2) {
            List<Integer> keys = new ArrayList<>(freqCount.keySet());
            int f1 = keys.get(0), f2 = keys.get(1);
            int c1 = freqCount.get(f1), c2 = freqCount.get(f2);
            
            if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) {
                return true;
            }

            if ((Math.abs(f1 - f2) == 1) && ((f1 > f2 && c1 == 1) || (f2 > f1 && c2 == 1))) {
                return true;
            }

            return false;
        } else {
            return false;
        }
    }
}