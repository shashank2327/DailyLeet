class Tuple {
    int removed;
    int row;
    int col;

    public Tuple (int removed, int row, int col) {
        this.removed = removed;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m =  grid[0].length;

        int[][] removal = new int[n][m]; // Keep track of minimum removals at each point;
        for (int[] x : removal) {
            Arrays.fill (x, (int)1e9);
        }
        removal[0][0] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        q.add(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] it = q.poll();
            int rmd = it[0];
            int r = it[1]; // current Row
            int c = it[2]; // current Col

            if (rmd > removal[r][c]) continue;
            if (r == n - 1 && c == m - 1) return removal[r][c];

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];  // new Row
                int nc = c + dy[i];  // new Column

                if (nr < n && nr >= 0 && nc >= 0 && nc < m) {
                    if (rmd + grid[nr][nc] < removal[nr][nc]) {
                        removal[nr][nc] = rmd + grid[nr][nc];
                        q.add(new int[]{removal[nr][nc], nr, nc});
                    }
                }
            }
        }

        return removal[n - 1][m - 1];
    }
}