import java.util.*;

class Solution {
    public boolean validgroup(int[] arr, int k) {
        if (arr.length % k != 0) return false;

        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        while (!freqMap.isEmpty()) {
            int start = freqMap.firstKey();
            int count = freqMap.get(start);

            for (int i = 0; i < k; i++) {
                int curr = start + i;
                if (!freqMap.containsKey(curr)) return false;
                int currCount = freqMap.get(curr);
                if (currCount < count) return false;
                if (currCount == count) freqMap.remove(curr);
                else freqMap.put(curr, currCount - count);
            }
        }

        return true;
    }
}
