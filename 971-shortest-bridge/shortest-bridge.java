class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        boolean found = false;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, n, vis, q);
                    found = true;
                    break;
                }
            }
        }

        int steps = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] it = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nr = dx[j] + it[0];
                    int nc = dy[j] + it[1];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n && !vis[nr][nc]) {
                        if (grid[nr][nc] == 1) {
                            return steps;
                        }
                        q.offer(new int[]{nr, nc});
                        vis[nr][nc] = true;
                    }
                }
            }
            steps++;
        }

        return 0;
    }

    private void dfs(int[][] grid, int i, int j, int n, boolean[][] vis, Queue<int[]> q) {
        vis[i][j] = true;
        q.offer(new int[]{i, j});
        for (int k = 0; k < 4; k++) {
            int nr = i + dx[k];
            int nc = j + dy[k];
            if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 1 && !vis[nr][nc]) {
                dfs(grid, nr, nc, n, vis, q);
            }
        }
    }
}