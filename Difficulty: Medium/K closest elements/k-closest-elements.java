class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            else return a[1] - b[1];
        });

        for (int val : arr) {
            if (val == x) continue;

            int diff = Math.abs(val - x);
            maxHeap.offer(new int[]{diff, val});

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]);
        }
        
        Collections.reverse(result);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
