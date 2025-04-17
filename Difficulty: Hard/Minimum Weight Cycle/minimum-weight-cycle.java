//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            Solution obj = new Solution();
            int res = obj.findMinCycle(V, edges);

            System.out.println(res);
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    static class Pair {
        int node, weight;
        Pair(int n, int w) {
            node = n;
            weight = w;
        }
    }

    public int findMinCycle(int V, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Build the adjacency list
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int minCycle = Integer.MAX_VALUE;

        // Try removing each edge one by one
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            // Temporarily remove the edge (u, v)
            adj.get(u).removeIf(p -> p.node == v && p.weight == w);
            adj.get(v).removeIf(p -> p.node == u && p.weight == w);

            // Run Dijkstra from u to v
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[u] = 0;

            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
            pq.add(new Pair(u, 0));

            while (!pq.isEmpty()) {
                Pair curr = pq.poll();
                int node = curr.node;
                int d = curr.weight;

                if (d > dist[node]) continue;

                for (Pair nei : adj.get(node)) {
                    int next = nei.node, wt = nei.weight;
                    if (dist[next] > d + wt) {
                        dist[next] = d + wt;
                        pq.add(new Pair(next, dist[next]));
                    }
                }
            }

            // If a path exists from u to v, we found a cycle
            if (dist[v] != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist[v] + w);
            }

            // Restore the edge (u, v)
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
};