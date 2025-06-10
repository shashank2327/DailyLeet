class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length; 
        int[][] dis = new int[n][n];
        for (int[] x : dis) {
            Arrays.fill(x, (int)1e9);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dis[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int maxDis = -1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            // int sz = q.size();
            // while (sz-- > 0) {
                int[] it = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = dx[i] + it[0];
                    int nc = dy[i] + it[1];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                        if (dis[it[0]][it[1]] + 1 < dis[nr][nc]) {
                            dis[nr][nc] = dis[it[0]][it[1]] + 1;
                            maxDis = Math.max(maxDis, dis[nr][nc]);
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            // }
        }
        return maxDis;
    }
}