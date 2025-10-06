class Solution {
    int[] rowMove = {2, 1, -1, -2, -2, -1, 1, 2};
    int[] colMove = {1, 2, 2, 1, -1, -2, -2, -1};
    ArrayList<ArrayList<Integer>> res;
    
    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        res = new ArrayList<>();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                board[i][j] = -1;
                row.add(-1);
            }
            res.add(row);
        }
        board[0][0] = 0;
        if (solve(board, 0, 0, 1, n)) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    res.get(i).set(j, board[i][j]);
        } else res.clear();
        return res;
    }

    boolean solve(int[][] board, int x, int y, int moveCount, int n) {
        if (moveCount == n * n) return true;
        for (int i = 0; i < 8; i++) {
            int nextX = x + rowMove[i];
            int nextY = y + colMove[i];
            if (isSafe(nextX, nextY, board, n)) {
                board[nextX][nextY] = moveCount;
                if (solve(board, nextX, nextY, moveCount + 1, n)) return true;
                board[nextX][nextY] = -1;
            }
        }
        return false;
    }

    boolean isSafe(int x, int y, int[][] board, int n) {
        return x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1;
    }
}
