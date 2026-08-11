class Tuple {
    public int row;
    public int col;

    public Tuple(int row, int col) {
        this.row = row;
        this.col = col;
    } 
}


class Solution {

    public static final int INF = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Tuple> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new Tuple(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                Tuple t = q.poll();
                int r = t.row;
                int c = t.col;

                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                        if (rooms[r][c] + 1 < rooms[nr][nc]) {
                            rooms[nr][nc] = rooms[r][c] + 1;
                            q.offer(new Tuple(nr, nc));
                        }
                    }
                }
            }
        }
    }
}