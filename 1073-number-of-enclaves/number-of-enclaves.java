class Solution {
    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] vis = new int[n][m];

        // traversing first row ans last row;
        for (int j = 0; j < m; j++) {

            if (vis[0][j] == 0 && board[0][j] == 1) {
                dfs(0, j, vis, board, dx, dy);
            }

            if (vis[n - 1][j] == 0 && board[n - 1][j] == 1) {
                dfs(n - 1, j, vis, board, dx, dy);
            }

        }

        // traversing first col and last col
        for (int j = 0; j < n; j++) {

            if (vis[j][0] == 0 && board[j][0] == 1) {
                dfs(j, 0, vis, board, dx, dy);
            }

            if (vis[j][m - 1] == 0 && board[j][m - 1] == 1) {
                dfs(j, m - 1, vis, board, dx, dy);
            }

        }
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int row, int col, int[][] vis, int[][] mat, int[] dx, int[] dy) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 
            && mat[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, mat, dx, dy);
            }
        }
    }
}