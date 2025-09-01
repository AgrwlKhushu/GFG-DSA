import java.util.*;

class Solution {
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> bucket = new TreeMap<>();
        int sum = 0;

        for (int i = 0; i < k; i++) {
            int x = arr[i];
            int old = freq.getOrDefault(x, 0);
            if (old > 0) {
                TreeSet<Integer> set = bucket.get(old);
                set.remove(x);
                if (set.isEmpty()) bucket.remove(old);
            }
            freq.put(x, old + 1);
            bucket.computeIfAbsent(old + 1, z -> new TreeSet<>()).add(x);
        }
        sum += bucket.lastEntry().getValue().first();

        for (int i = k; i < n; i++) {
            int out = arr[i - k];
            int in = arr[i];
            int oldOut = freq.get(out);
            TreeSet<Integer> setOut = bucket.get(oldOut);
            setOut.remove(out);
            if (setOut.isEmpty()) bucket.remove(oldOut);
            if (oldOut == 1) {
                freq.remove(out);
            } else {
                freq.put(out, oldOut - 1);
                bucket.computeIfAbsent(oldOut - 1, z -> new TreeSet<>()).add(out);
            }

            int oldIn = freq.getOrDefault(in, 0);
            if (oldIn > 0) {
                TreeSet<Integer> setIn = bucket.get(oldIn);
                setIn.remove(in);
                if (setIn.isEmpty()) bucket.remove(oldIn);
            }
            freq.put(in, oldIn + 1);
            bucket.computeIfAbsent(oldIn + 1, z -> new TreeSet<>()).add(in);

            sum += bucket.lastEntry().getValue().first();
        }
        return sum;
    }
}
