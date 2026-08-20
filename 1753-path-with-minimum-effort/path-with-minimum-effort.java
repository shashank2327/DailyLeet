class Tuple {
    int dis;
    int row;
    int col;

    public Tuple(int dis, int row, int col) {
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}

class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dis = new int[n][m];
        for (int[] row: dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dis[0][0] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.dis, b.dis));
        pq.offer(new Tuple(0, 0, 0));


        while (!pq.isEmpty()) {
            Tuple token = pq.poll();
            int d = token.dis;
            int r = token.row;
            int c = token.col;

            if (dis[r][c] < d) continue;

            if (r == n - 1 && c == m - 1) return d;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                    int diffSoFar = Math.max(diff, d);

                    if (diffSoFar < dis[nr][nc]) {
                        pq.offer(new Tuple(diffSoFar, nr, nc));
                        dis[nr][nc] = diffSoFar;
                    }
                }
            }
        }
        

        return -1;
    }
}