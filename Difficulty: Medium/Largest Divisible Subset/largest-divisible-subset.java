import java.util.*;

class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen = 0;
        List<Integer> maxSubset = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> bestPath = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                        bestPath = buildSubset(arr, prev, j);
                    } else if (dp[j] + 1 == dp[i]) {
                        List<Integer> candidate = buildSubset(arr, prev, j);
                        if (isLexGreater(candidate, bestPath)) {
                            prev[i] = j;
                            bestPath = candidate;
                        }
                    }
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxSubset = buildSubset(arr, prev, i);
            } else if (dp[i] == maxLen) {
                List<Integer> candidate = buildSubset(arr, prev, i);
                if (isLexGreater(candidate, maxSubset)) {
                    maxSubset = candidate;
                }
            }
        }

        Collections.sort(maxSubset);
        return new ArrayList<>(maxSubset);
    }

    private List<Integer> buildSubset(int[] arr, int[] prev, int index) {
        List<Integer> subset = new ArrayList<>();
        while (index != -1) {
            subset.add(arr[index]);
            index = prev[index];
        }
        Collections.reverse(subset);
        return subset;
    }

    private boolean isLexGreater(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) > b.get(i);
            }
        }
        return a.size() > b.size();  // tie-breaker
    }
}
