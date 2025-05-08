class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] minObs = new int[n][m];
        for (int[] x : minObs) {
            Arrays.fill(x, (int)1e9);
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        minObs[0][0] = 0;

        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{0, 0, 0});

        while (!deq.isEmpty()) {
            int[] curr = deq.poll();
            int o = curr[0];
            int r = curr[1];
            int c = curr[2];


            if (r == n - 1 && c == m - 1) return minObs[r][c];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && minObs[nr][nc] == (int)1e9) {
                    if (grid[nr][nc] == 1) {
                        minObs[nr][nc] = o + 1;
                        deq.addLast(new int[] {o + 1, nr, nc});
                    } else {
                        minObs[nr][nc] = o;
                        deq.addFirst(new int[]{o, nr, nc});
                    }
                }
            }
        }

        return minObs[n - 1][m - 1];
    }
}