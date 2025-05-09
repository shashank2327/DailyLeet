// class Info {
//     int dist;
//     int stp;
//     int row;
//     int col;

//     public Info (int dist, int stp, int row, int col) {
//         this.dist = dist;
//         this.stp = stp;
//         this.row = row;
//         this.col = col;
//     }
// }

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][][] vis = new boolean[n][m][k + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, k});
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                int[] curr = q.peek();
                q.remove();
                if (curr[0] == n - 1 && curr[1] == m - 1) return steps;

                for (int i = 0; i < 4; i++) {
                    int nr = curr[0] + dx[i];
                    int nc = curr[1] + dy[i];
                    int obs = curr[2];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                        if (grid[nr][nc] == 0 && !vis[nr][nc][obs]) {
                            vis[nr][nc][obs] = true;
                            q.add(new int[]{nr, nc, obs});
                        } else if (grid[nr][nc] == 1 && !vis[nr][nc][obs] && obs > 0) {
                            vis[nr][nc][obs] = true;
                            q.add(new int[]{nr , nc, obs - 1});
                        }
                    }
                }
                size--;
            }
            steps++;
        }
        return -1;
    }
}


