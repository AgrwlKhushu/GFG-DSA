class Solution {
    public int minCostPath(int[][] mat) {
        // code here
        
        int n = mat.length, m = mat[0].length;
        int left = 0, right = 1000000, res = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean[][] vis = new boolean[n][m];
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0, 0});
            vis[0][0] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if (cur[0] == n-1 && cur[1] == m-1) break;
                for (int[] dir : dirs) {
                    int ni = cur[0] + dir[0], nj = cur[1] + dir[1];
                    if (ni >= 0 && nj >= 0 && ni < n && nj < m && !vis[ni][nj] && Math.abs(mat[cur[0]][cur[1]] - mat[ni][nj]) <= mid) {
                        vis[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
            if (vis[n-1][m-1]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
