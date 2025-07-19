class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int startRow = entrance[0];
        int startCol = entrance[1];

        q.offer(new int[]{startRow, startCol});
        vis[startRow][startCol] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int k = 0; k < sz; k++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];

                for (int i = 0; i < 4; i++) {
                    int nrow = row + dx[i];
                    int ncol = col + dy[i];

                    if (nrow < 0 || ncol < 0 || nrow >= n || ncol >= m) {
                        if (row != startRow || col != startCol) {
                            return steps;
                        }
                    }

                    if (isValid(nrow, ncol, n, m) && maze[nrow][ncol] == '.' && !vis[nrow][ncol]) {
                        vis[nrow][ncol] = true;
                        q.offer(new int[]{nrow, ncol});
                    }
                }
            }

            steps++;
        }


        return -1;
    }

    private boolean isValid(int row, int col, int n, int m) {
        if (row >= 0 && col >= 0 && row < n && col < m) {
            return true;
        }
        return false;
    }
}