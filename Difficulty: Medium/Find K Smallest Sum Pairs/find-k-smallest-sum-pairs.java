class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        // code here
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (arr1[a[0]] + arr2[a[1]]) - (arr1[b[0]] + arr2[b[1]]));
        int n1 = arr1.length, n2 = arr2.length;
        for (int i = 0; i < Math.min(n1, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (result.size() < k && !pq.isEmpty()) {
            int[] idx = pq.poll();
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(arr1[idx[0]]);
            pair.add(arr2[idx[1]]);
            result.add(pair);
            if (idx[1] + 1 < n2) {
                pq.offer(new int[]{idx[0], idx[1] + 1});
            }
        }
        return result;
    }
}
