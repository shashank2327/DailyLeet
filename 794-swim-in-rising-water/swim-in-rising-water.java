class Tuple {
    int time;
    int row;
    int col;

    public Tuple(int time, int row, int col) {
        this.time = time;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        int[][] tm = new int[n][n];
        for (int[] x : tm) {
            Arrays.fill(x, (int)1e9);
        }
        tm[0][0] = grid[0][0];

        PriorityQueue<Tuple> q = new PriorityQueue<>((x, y) -> x.time - y.time);
        q.add(new Tuple(grid[0][0], 0, 0));

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int t = it.time;
            int r = it.row;
            int c = it.col;

            if (t > tm[r][c]) continue;

            if (r == n - 1 && c == n - 1) return tm[r][c];

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                    if (grid[nr][nc] <= t) {
                        if (t < tm[nr][nc]) {
                            tm[nr][nc] = t;
                            q.add(new Tuple(t, nr, nc));
                        }
                    } else {
                        if (grid[nr][nc] < tm[nr][nc]) {
                            tm[nr][nc] = grid[nr][nc];
                            q.add(new Tuple(grid[nr][nc], nr, nc));
                        }
                    }
                }
            }
        }

        return tm[n - 1][n - 1];
    }
}