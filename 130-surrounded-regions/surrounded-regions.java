class Solution {
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O' && !vis[i][0]) dfs(grid, vis, i, 0);
            if (grid[i][m - 1] == 'O' && !vis[i][m - 1]) dfs(grid, vis, i, m - 1);
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 'O' && !vis[0][j]) dfs(grid, vis, 0, j);
            if (grid[n - 1][j] == 'O' && !vis[n - 1][j]) dfs (grid, vis, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O' && !vis[i][j]) {
                    grid[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, boolean[][] vis, int r, int c) {
        vis[r][c] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr >= 0 && nr < board.length && 
                nc >= 0 && nc < board[0].length && 
                !vis[nr][nc] && board[nr][nc] == 'O'
            ) {
                dfs(board, vis, nr, nc);
            }
        }
    }
}