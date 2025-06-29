class Quad {
    int time;
    boolean flag;
    int row;
    int col;

    public Quad(int time, boolean flag, int row, int col) {
        this.time = time;
        this.flag = flag;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] minTime = new int[n][m];
        for (int[] row : minTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        PriorityQueue<Quad> pq = new PriorityQueue<>((q1, q2) -> q1.time - q2.time);
        minTime[0][0] = 0;
        pq.offer(new Quad(0, true, 0, 0));

        while (!pq.isEmpty()) {
            Quad token = pq.poll();
            int time = token.time;
            boolean flag = token.flag;
            int row = token.row;
            int col = token.col;

            if (row == n - 1 && col == m - 1) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + row;
                int nc = dy[i] + col;
                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int travelTime = flag ? 1 : 2;
                    int timeRequired = Math.max(time, moveTime[nr][nc]) + travelTime;
                    if (timeRequired < minTime[nr][nc]) {
                        minTime[nr][nc] = timeRequired;
                        pq.offer(new Quad(timeRequired, !flag, nr, nc));
                    }
                }
            }
        }

        return 0;
    }
}