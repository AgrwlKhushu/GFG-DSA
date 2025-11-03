class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            reverseGraph.get(edge[1]).add(edge[0]);
        }
        int[] outDegree = new int[V];
        for (int i = 0; i < V; i++) {
            outDegree[i] = graph.get(i).size();
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (outDegree[i] == 0) queue.offer(i);
        }
        boolean[] safe = new boolean[V];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;
            for (int prev : reverseGraph.get(node)) {
                outDegree[prev]--;
                if (outDegree[prev] == 0) queue.offer(prev);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) if (safe[i]) result.add(i);
        return result;
    }
}