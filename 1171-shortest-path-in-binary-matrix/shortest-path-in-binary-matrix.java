class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;

        int[][] vis = new int[n][n];

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(1, 0, 0));
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            int d = curr.dis;
            int r = curr.row;
            int c = curr.col;

            if (r == n - 1 && c == n - 1) return d;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nrow = r + i;
                    int ncol = c + j;
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0) {
                        q.add(new Tuple(d + 1, nrow, ncol));
                        grid[nrow][ncol] = 1;
                    }
                }
            }

        }

        return -1;
    }
}

class Tuple {
    int dis;
    int row;
    int col;

    Tuple (int dis, int row, int col) {
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}