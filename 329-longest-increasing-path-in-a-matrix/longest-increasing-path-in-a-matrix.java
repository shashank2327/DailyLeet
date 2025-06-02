class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] indegree = new int[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    int nr = i + dx[k];
                    int nc = j + dy[k];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        if (matrix[nr][nc] < matrix[i][j]) {
                            indegree[i][j]++;
                        }
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (indegree[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.remove();
                int row = cell[0];
                int col = cell[1];
                for (int j = 0; j < 4; j++) {
                    int nr = row + dx[j];
                    int nc = col + dy[j];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                    matrix[nr][nc] > matrix[row][col] &&
                    indegree[nr][nc] > 0) {
                        indegree[nr][nc]--;
                        if (indegree[nr][nc] == 0) {
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
            level++;
        }

        return level;
    }
}