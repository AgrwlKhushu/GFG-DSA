class Solution {
    public int diameter(int V, int[][] edges) {
        // Code here
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] result1 = dfs(0, -1, adj);
        int farthest = result1[0];
        int[] result2 = dfs(farthest, -1, adj);
        return result2[1];
    }
    
    private int[] dfs(int node, int parent, List<List<Integer>> adj) {
        int farthestNode = node;
        int maxDist = 0;
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                int[] next = dfs(neighbor, node, adj);
                if (next[1] + 1 > maxDist) {
                    maxDist = next[1] + 1;
                    farthestNode = next[0];
                }
            }
        }
        return new int[] {farthestNode, maxDist};
    }
}