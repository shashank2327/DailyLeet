class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;  // number of rows;
        int m = grid[0].length;  // number of cols;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> q = new LinkedList<>();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    flag = false;
                }
            }
        }

        if (flag) return 0;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];
                for (int i = 0; i < 4; i++) {
                    int nr = row + dx[i];
                    int nc = col + dy[i];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            level++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }


        return level - 1;
    }
}