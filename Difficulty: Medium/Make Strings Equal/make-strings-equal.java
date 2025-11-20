class Solution {
    public int minCost(String s, String t, char[][] transform, int[] cost) {
        // code here
        
        int n = s.length();
        if (t.length() != n) return -1;
        int ALPH = 26;
        int[][] dist = new int[ALPH][ALPH];
        for (int i = 0; i < ALPH; i++) {
            for (int j = 0; j < ALPH; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        for (int i = 0; i < transform.length; i++) {
            int from = transform[i][0] - 'a';
            int to = transform[i][1] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }
        for (int k = 0; k < ALPH; k++) {
            for (int i = 0; i < ALPH; i++) {
                for (int j = 0; j < ALPH; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (a == b) continue;
            int min = Integer.MAX_VALUE;
            for (int c = 0; c < ALPH; c++) {
                int x = dist[a - 'a'][c];
                int y = dist[b - 'a'][c];
                if (x < Integer.MAX_VALUE / 2 && y < Integer.MAX_VALUE / 2) {
                    min = Math.min(min, x + y);
                }
            }
            if (min == Integer.MAX_VALUE) return -1;
            total += min;
        }
        return total;
    }
}