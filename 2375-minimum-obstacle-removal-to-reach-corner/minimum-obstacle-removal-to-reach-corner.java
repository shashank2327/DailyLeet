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

        PriorityQueue<Tuple> q = new PriorityQueue<>((x, y) -> x.removed - y.removed);
        q.add(new Tuple(0, 0, 0));

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int rmd = it.removed;
            int r = it.row; // current Row
            int c = it.col; // current Col

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
                        q.add(new Tuple(removal[nr][nc], nr, nc));
                    }
                }
            }
        }

        return removal[n - 1][m - 1];
    }
}