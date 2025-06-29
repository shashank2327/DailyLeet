class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] minTime = new int[n][m];
        for (int[] row : minTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // {time, row, col};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minTime[0][0] = 0;
        pq.offer(new int[] {0, 0, 0,});

        // for traversing all four directions;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            int[] token = pq.poll();
            int time = token[0];
            int row = token[1];
            int col = token[2];

            if (row == n - 1 && col == m - 1) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int timeRequired = Math.max(time, moveTime[nr][nc]) + 1;
                    if (minTime[nr][nc] > timeRequired) {
                        minTime[nr][nc] = timeRequired;
                        pq.offer(new int[]{timeRequired, nr, nc});
                    }
                }
            }

        }
        return 0;
    }
}
/*
0   4
4   4

0   0   0
0   0   0

*/