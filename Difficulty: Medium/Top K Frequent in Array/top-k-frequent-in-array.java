class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]
        );

        for (Map.Entry<Integer, Integer> entry : freq.entrySet())
            pq.add(new int[] {entry.getKey(), entry.getValue()});

        ArrayList<Integer> result = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty())
            result.add(pq.poll()[0]);

        return result;
    }
}
