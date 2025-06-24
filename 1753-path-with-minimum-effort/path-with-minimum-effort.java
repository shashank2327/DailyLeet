class Tuple {
    int diff;
    int row;
    int col;

    public Tuple(int diff, int row, int col) {
        this.diff = diff;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((t1, t2) -> t1.diff - t2.diff);
        int[][] dis = new int[n][m];
        for (int[] x : dis) Arrays.fill(x, (int)1e9);

        pq.offer(new Tuple(0, 0, 0));
        dis[0][0] = 0;

        while (!pq.isEmpty()) {
            Tuple it = pq.poll();
            int d = it.diff;
            int r = it.row;
            int c = it.col;

            if (r == n - 1 && c == m - 1) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + r;
                int nc = dy[i] + c;

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int effort = Math.max(d, Math.abs(heights[r][c] - heights[nr][nc]));
                    if (effort < dis[nr][nc]) {
                        dis[nr][nc] = effort;
                        pq.offer(new Tuple(effort, nr, nc));
                    }
                }
            }
        }

        return -1;
    }
}