class Solution {
    public int countPaths(int V, int[][] edges) {
        // code here
        
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for(int[] e : edges){
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[V];
        int[] ways = new int[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0});
        int mod = (int)1e9 + 7;

        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            int node = (int)cur[0];
            long d = cur[1];
            if(d > dist[node]) continue;

            for(int[] nxt : graph.get(node)){
                int nb = nxt[0];
                long w = nxt[1];
                if(dist[node] + w < dist[nb]){
                    dist[nb] = dist[node] + w;
                    ways[nb] = ways[node];
                    pq.offer(new long[]{nb, dist[nb]});
                } else if(dist[node] + w == dist[nb]){
                    ways[nb] = (ways[nb] + ways[node]) % mod;
                }
            }
        }

        return ways[V - 1];
    }
}
