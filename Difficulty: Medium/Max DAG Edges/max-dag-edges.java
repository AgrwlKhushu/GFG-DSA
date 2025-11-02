class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        // Code here
        
        int maxPossible = V * (V - 1) / 2;
        int currentEdges = edges.length;
        return maxPossible - currentEdges;
    }
}