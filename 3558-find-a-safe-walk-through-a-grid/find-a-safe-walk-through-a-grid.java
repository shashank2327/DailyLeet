class Tuple {
    int hth;
    int row;
    int col;

    public Tuple (int hth, int row, int col) {
        this.hth = hth;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] heal = new int[n][m]; // Keep track of maximum health at each point;
        heal[0][0] = health - grid.get(0).get(0);
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(heal[0][0], 0, 0));

        while (!q.isEmpty()) {
            int h = q.peek().hth;
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();

            if (h < heal[r][c]) continue;

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newHealth = h - grid.get(nr).get(nc);
                    if (newHealth > heal[nr][nc]) {
                        heal[nr][nc] = newHealth;
                        q.add(new Tuple(newHealth, nr, nc));
                    }
                }
            }
        }

        return heal[n - 1][m - 1] <= 0 ? false : true;
    }
}