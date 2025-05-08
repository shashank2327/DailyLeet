class Quad {
    int tm;
    boolean flag;
    int row;
    int col;

    public Quad (int tm, boolean flag, int row, int col) {
        this.tm = tm;
        this.flag = flag;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        long[][] time = new long[n][m];
        for (long[] x : time) {
            Arrays.fill(x, Long.MAX_VALUE);
        }
        time[0][0] = 0;

        PriorityQueue<Quad> pq = new PriorityQueue<>((x, y) -> x.tm - y.tm);
        pq.offer(new Quad(0, true, 0, 0));

        while (!pq.isEmpty()) {
            int t = pq.peek().tm;
            boolean f = pq.peek().flag;
            int r = pq.peek().row;
            int c = pq.peek().col;
            pq.remove();

            if (t > time[r][c]) continue;

            if (r == n - 1 && c == m - 1) return t;

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, -1, 0, 1};
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (t >= moveTime[nr][nc]) {
                        int newTime = f == true ? t + 1 : t + 2;
                        if (newTime < time[nr][nc]) {
                            time[nr][nc] = newTime;
                            pq.add(new Quad(newTime, !f, nr, nc));
                        }
                    } else {
                        int newTime = f == true ? moveTime[nr][nc] + 1 : moveTime[nr][nc] + 2;
                        if (newTime < time[nr][nc]) {
                            time[nr][nc] = newTime;
                            pq.add(new Quad(newTime, !f, nr, nc));
                        }
                    }
                }
            }
        }

        return 0;
    }
}