class Solution {
    boolean flag;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;

        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid2[i][j] == 1) {
                    flag = true;
                    dfs(grid2, grid1, i, j, n, m, vis);
                    if (flag) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    private void dfs(int[][] grid2, int[][] grid1, int row, int col, int n , int m, boolean[][] vis) {
        vis[row][col] = true;
        if (grid1[row][col] != 1) flag = false;

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && !vis[nrow][ncol] && grid2[nrow][ncol] == 1) {
                dfs(grid2, grid1, nrow, ncol, n, m, vis);
            } 
        }
    }
}

// do a dfs in grid2;
// and check every cell which i '1' in grid2 should also be one in grid1 for being a subisland