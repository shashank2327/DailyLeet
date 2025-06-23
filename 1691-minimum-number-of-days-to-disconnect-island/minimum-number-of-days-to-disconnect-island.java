class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int intialIslands = numberOfComponents(grid, n, m);
        if (intialIslands == 0 || intialIslands > 1) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int islands = numberOfComponents(grid, n, m);
                    if (islands == 0 || islands > 1) {
                        return 1;
                    }

                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private int numberOfComponents(int[][] grid, int n , int m) {
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    cnt++;
                    dfs(i, j, vis, grid, n, m);
                }
            }
        }

        return cnt;
    }

    private void dfs(int i, int j, boolean[][] vis, int[][] grid, int n, int m) {
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nr = i + dx[k];
            int nc = j + dy[k];
            if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1 && !vis[nr][nc]) {
                dfs(nr, nc, vis, grid, n, m);
            } 
        }
    }
}