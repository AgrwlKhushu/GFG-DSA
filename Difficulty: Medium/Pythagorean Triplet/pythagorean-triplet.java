import java.util.*;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        Set<Integer> squaredSet = new HashSet<>();

        // Square and fill frequency map and set
        for (int num : arr) {
            int sq = num * num;
            freqMap.put(sq, freqMap.getOrDefault(sq, 0) + 1);
            squaredSet.add(sq);
        }

        // Convert squared values into list
        List<Integer> squares = new ArrayList<>(squaredSet);
        int m = squares.size();

        // Try all unordered pairs (a² + b²)
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int a2 = squares.get(i);
                int b2 = squares.get(j);
                int sum = a2 + b2;

                if (squaredSet.contains(sum)) {
                    // Ensure valid distinct indices
                    int countA = freqMap.get(a2);
                    int countB = freqMap.get(b2);
                    int countC = freqMap.get(sum);

                    // Count conditions:
                    // If a², b², and c² are all same → need at least 3 of them
                    if (a2 == b2 && b2 == sum && countA >= 3) return true;

                    // If two are equal, check counts accordingly
                    else if ((a2 == b2 && countA >= 2 && countC >= 1) ||
                             (a2 == sum && countA >= 2 && countB >= 1) ||
                             (b2 == sum && countB >= 2 && countA >= 1)) return true;

                    // All distinct
                    else if (a2 != b2 && a2 != sum && b2 != sum) return true;
                }
            }
        }

        return false;
    }
}
