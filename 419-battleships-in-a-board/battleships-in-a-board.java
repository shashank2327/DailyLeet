class Solution {
    public int countBattleships(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'X' && !vis[i][j]) {
                    dfs(grid, vis, i, j, n, m);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(char[][] grid, boolean[][] vis, int i, int j, int n, int m) {
        vis[i][j] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int nr = i + dx[k];
            int nc = j + dy[k];
            if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 'X' && !vis[nr][nc]) {
                dfs(grid, vis, nr, nc, n, m);
            }
        }
    }
}