class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int r = -1;
        int c = -1;
        boolean flag = false;
        boolean outer = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j] && !flag) {
                    dfs(grid, i, j, n, vis);
                    flag = true;
                } else if (grid[i][j] == 1 && !vis[i][j] && flag) {
                    r = i;
                    c = j;
                    outer = true;
                    break;
                }
            }
            if (outer) {
                break;
            }
        }
        for (int[] x : grid) {
            System.out.println(Arrays.toString(x));
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.offer(new int[]{r, c, 0});
        while (!q.isEmpty()) {
            int[] it = q.poll();
            int i = it[0];
            int j = it[1];
            int dis = it[2];
            for (int k = 0; k < 4; k++) {
                int nr = i + dx[k];
                int nc = j + dy[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (grid[i][j] == 1 && grid[nr][nc] == 0 && !vis[nr][nc]) {
                        vis[nr][nc] = true;
                        q.offer(new int[]{nr, nc, dis + 1});
                    }
                    if (grid[nr][nc] == 1 && grid[i][j] == 1 && !vis[nr][nc]) {
                        vis[nr][nc] = true;
                        q.offer(new int[]{nr, nc, 0});
                    }
                    if (grid[nr][nc] == 2 && grid[i][j] == 0 && vis[nr][nc]) {
                        return dis;
                    }
                    if (grid[nr][nc] == 0 && grid[i][j] == 0 && !vis[nr][nc]) {
                        vis[nr][nc] = true;
                        q.offer(new int[]{nr, nc, dis + 1});
                    }
                }
            }
        }
        return 0;
    }

    private void dfs(int[][] grid, int i, int j, int n, boolean[][] vis) {
        grid[i][j] = 2;
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nr = i + dx[k];
            int nc = j + dy[k];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1 && !vis[nr][nc]) {
                dfs(grid, nr, nc, n, vis);
            }
        }
    }
}