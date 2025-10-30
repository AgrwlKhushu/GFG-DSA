class Solution {
    public void fill(char[][] grid) {
        // Code here
        
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O') dfs(grid, i, 0, n, m);
            if (grid[i][m - 1] == 'O') dfs(grid, i, m - 1, n, m);
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 'O') dfs(grid, 0, j, n, m);
            if (grid[n - 1][j] == 'O') dfs(grid, n - 1, j, n, m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') grid[i][j] = 'X';
                if (grid[i][j] == '#') grid[i][j] = 'O';
            }
        }
    }
    
    private void dfs(char[][] grid, int x, int y, int n, int m) {
        grid[x][y] = '#';
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 'O') {
                dfs(grid, nx, ny, n, m);
            }
        }
    }
}
