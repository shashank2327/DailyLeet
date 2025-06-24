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
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(1, 0, 0));
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                Tuple token = q.poll();
                int d = token.dis;
                int r = token.row;
                int c = token.col;

                if (r == n - 1 && c == n - 1) return d;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int nr = r + i;
                        int nc = c + j;
                        if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0) {
                            grid[nr][nc] = 1;
                            q.offer(new Tuple(d + 1, nr, nc));
                        }
                    }
                }
            }
        }

        return -1;
    }
}