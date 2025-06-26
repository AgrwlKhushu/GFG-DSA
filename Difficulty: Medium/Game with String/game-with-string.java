class Solution {
    public int minValue(String s, int k) {
        // code here
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
        }

        while (k > 0 && !maxHeap.isEmpty()) {
            int top = maxHeap.poll();
            top--;
            k--;
            if (top > 0) {
                maxHeap.add(top);
            }
        }

        int result = 0;
        while (!maxHeap.isEmpty()) {
            int val = maxHeap.poll();
            result += val * val;
        }

        return result;
    }
}