class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) adj.get(p[1]).add(p[0]);
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++)
            for (int v : adj.get(i)) indegree[v]++;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0) q.add(i);
        ArrayList<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for (int v : adj.get(node)) {
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }
        if (order.size() != n) return new ArrayList<>();
        return order;
    }
}