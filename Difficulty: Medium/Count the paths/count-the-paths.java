import java.util.*;

class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // Step 2: Initialize memoization array
        Integer[] memo = new Integer[V];

        // Step 3: Call DFS with memoization
        return dfs(graph, src, dest, memo);
    }

    private int dfs(List<List<Integer>> graph, int node, int dest, Integer[] memo) {
        if (node == dest) return 1;

        if (memo[node] != null) return memo[node];

        int count = 0;
        for (int neighbor : graph.get(node)) {
            count += dfs(graph, neighbor, dest, memo);
        }

        memo[node] = count;
        return count;
    }
}
