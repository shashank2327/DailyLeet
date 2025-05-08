class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        vis[0][0] = true;

        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{0, 0, 0});

        while (!deq.isEmpty()) {
            int[] curr = deq.poll();
            int o = curr[0];
            int r = curr[1];
            int c = curr[2];


            if (r == n - 1 && c == m - 1) return o;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    if (grid[nr][nc] == 1) {
                        vis[nr][nc] = true;
                        deq.addLast(new int[] {o + 1, nr, nc});
                    } else {
                        vis[nr][nc] = true;
                        deq.addFirst(new int[]{o, nr, nc});
                    }
                }
            }
        }

        return 0;
    }
}