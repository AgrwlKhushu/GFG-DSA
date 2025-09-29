class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        // code here
        
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        int res = Integer.MIN_VALUE;
        java.util.Deque<Integer> deque = new java.util.ArrayDeque<>();
        for (int i = a; i <= n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - b) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && prefix[deque.peekLast()] >= prefix[i - a]) {
                deque.pollLast();
            }
            deque.offerLast(i - a);
            res = Math.max(res, prefix[i] - prefix[deque.peekFirst()]);
        }
        return res;
    }
}