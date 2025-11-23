class Solution {
    
    int[] parent;

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px != py) parent[px] = py;
    }
    
    int maxRemove(int[][] stones) {
        // Code here
        
        int n = stones.length;
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        int idx = 0;

        for (int[] s : stones) {
            if (!row.containsKey(s[0])) row.put(s[0], idx++);
            if (!col.containsKey(s[1])) col.put(s[1], idx++);
        }

        parent = new int[idx];
        for (int i = 0; i < idx; i++) parent[i] = i;

        for (int[] s : stones) {
            union(row.get(s[0]), col.get(s[1]));
        }

        Set<Integer> roots = new HashSet<>();
        for (int[] s : stones) {
            roots.add(find(row.get(s[0])));
        }

        return n - roots.size();
    }
};
