class Tuple {
    int cost;
    int row;
    int col;

    public Tuple(int cost, int row, int col) {
        this.cost = cost;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] minCost = new int[n][m];
        for (int[] x : minCost) {
            Arrays.fill(x, (int)1e9);
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((t1, t2) -> t1.cost - t2.cost);

        pq.offer(new Tuple(0, 0, 0)); // I am on (0, 0) cell with cost = 0;
        minCost[0][0] = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!pq.isEmpty()) {
            Tuple it = pq.poll();
            int currCost = it.cost;
            int row = it.row;
            int col = it.col;

            for (int i = 0; i < 4; i++) {
                if (i + 1 == grid[row][col]) { // going in the same direction
                    int nr = dx[i] + row;
                    int nc = dy[i] + col;
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && minCost[nr][nc] > currCost) {
                        minCost[nr][nc] = currCost;
                        pq.offer(new Tuple(currCost, nr, nc));
                    }
                } else {
                    int nr = dx[i] + row;
                    int nc = dy[i] + col;
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && minCost[nr][nc] > currCost + 1) {
                        minCost[nr][nc] = currCost + 1;
                        pq.offer(new Tuple(currCost + 1, nr, nc));
                    }
                }
            }
        }
        return minCost[n - 1][m - 1];
    }
}
// for every cell try out all four directions;
// if going in the same direction as specified by cell (cost + 0);
// else (cost + 1);


/* right (row, col + 1)  // {0, 0, 1, -1};   // dy = {1, -1, 0, 0};
   left  (row, col - 1)
   down  (row + 1, col)
   up    (row - 1, col)
   */