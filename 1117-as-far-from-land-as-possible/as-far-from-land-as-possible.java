class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length; 
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        if (q.isEmpty() || q.size() == n * n) return -1;
        int steps = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int[] it = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = dx[i] + it[0];
                    int nc = dy[i] + it[1];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return steps - 1;
    }
}