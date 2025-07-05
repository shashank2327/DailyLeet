class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length; // number of rows;
        int m = grid[0].length; // number of cols;

        boolean[][] vis = new boolean[n][m]; // keep tracks of cell, being visited;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int currArea = bfs(grid, i, j, n, m, vis);

                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }

        return maxArea;
    }

    public int bfs(int[][] grid, int r, int c, int n, int m, boolean[][] vis) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{r, c});
        cnt++;
        vis[r][c] = true;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                    cnt++;
                    q.offer(new int[]{nrow, ncol});
                    vis[nrow][ncol] = true;
                }
            }
        }

        return cnt;
    }
}