class Solution {
    public int shortestPath(int V, int a, int b, int[][] edges) {
        // code here
        
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] e : edges) {
            adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(new int[]{e[1], e[2]});
            adj.computeIfAbsent(e[1], k -> new ArrayList<>()).add(new int[]{e[0], e[2]});
        }
        int[] distA = new int[V];
        int[] distB = new int[V];
        Arrays.fill(distA, Integer.MAX_VALUE);
        Arrays.fill(distB, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
        distA[a] = 0;
        pq.add(new int[]{a, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            if (d > distA[u]) continue;
            if (adj.containsKey(u)) {
                for (int[] next : adj.get(u)) {
                    int v = next[0], w = next[1];
                    if (distA[v] > distA[u] + w) {
                        distA[v] = distA[u] + w;
                        pq.add(new int[]{v, distA[v]});
                    }
                }
            }
        }
        distB[b] = 0;
        pq.clear();
        pq.add(new int[]{b, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            if (d > distB[u]) continue;
            if (adj.containsKey(u)) {
                for (int[] next : adj.get(u)) {
                    int v = next[0], w = next[1];
                    if (distB[v] > distB[u] + w) {
                        distB[v] = distB[u] + w;
                        pq.add(new int[]{v, distB[v]});
                    }
                }
            }
        }
        int ans = distA[b];
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[3];
            if (distA[u] != Integer.MAX_VALUE && distB[v] != Integer.MAX_VALUE)
                ans = Math.min(ans, distA[u] + w + distB[v]);
            if (distA[v] != Integer.MAX_VALUE && distB[u] != Integer.MAX_VALUE)
                ans = Math.min(ans, distA[v] + w + distB[u]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}