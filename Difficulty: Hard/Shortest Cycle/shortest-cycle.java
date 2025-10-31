class Solution {
    public int shortCycle(int V, int[][] edges) {
        // Code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int res = Integer.MAX_VALUE;
        for (int start = 0; start < V; start++) {
            int[] dist = new int[V];
            int[] par = new int[V];
            Arrays.fill(dist, -1);
            Queue<Integer> q = new LinkedList<>();
            dist[start] = 0;
            q.add(start);
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        par[v] = u;
                        q.add(v);
                    } else if (par[u] != v) {
                        res = Math.min(res, dist[u] + dist[v] + 1);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}