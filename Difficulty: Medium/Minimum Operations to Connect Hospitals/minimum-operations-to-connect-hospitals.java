class Solution {
    public int minConnect(int V, int[][] edges) {
        // code here
        
        int[] parent = new int[V];
        for (int i = 0; i < V; ++i) parent[i] = i;
        int redundant = 0;
        for (int[] edge : edges) {
            int u = find(parent, edge[0]);
            int v = find(parent, edge[1]);
            if (u == v) redundant++;
            else parent[u] = v;
        }
        int components = 0;
        for (int i = 0; i < V; ++i) {
            if (parent[i] == i) components++;
        }
        if (redundant >= components - 1)
            return components - 1;
        return -1;
    }
    
    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
