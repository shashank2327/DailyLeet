class Tuple {
    int dis;
    int row;
    int col;

    public Tuple (int dis, int row, int col) {
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int[][] dis = new int[n][m];
        for (int[] x : dis) {
            Arrays.fill(x, (int)1e9);
        }
        dis[0][0] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.dis - y.dis);
        pq.add(new Tuple(0, 0, 0));

        while (!pq.isEmpty()) {
            int currDis = pq.peek().dis;
            int r = pq.peek().row;
            int c = pq.peek().col;
            pq.remove();
            
            if (r == n - 1 && c == m - 1) {
                return dis[n - 1][m - 1];
            }

            for (int i = 0; i < 4; i++) {
                int nrow = r + dx[i];
                int ncol = c + dy[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    
                    int nCost = currDis + (i != (grid[r][c] - 1) ? 1 : 0);

                    if (dis[nrow][ncol] > nCost) {
                        dis[nrow][ncol] = nCost;
                        pq.offer(new Tuple(nCost, nrow, ncol));
                    }
                }
            }
        }

        return 0;
    }
}

