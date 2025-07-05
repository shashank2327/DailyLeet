class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;  // number of rows;
        int m = grid[0].length;  // number of cols;.

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dx[k];
                        int nc = j + dy[k];
                        if (!isValid(grid, n, m, nr, nc)) {
                            cnt++;
                        }
                    } 
                }         
            }
        }

        return cnt;

    }

    boolean isValid(int[][] grid, int n, int m, int row, int col) {
        if (row >= 0 && col >= 0 && row < n && col < m && grid[row][col] == 1) {
            return true;
        } else {
            return false;
        }
    }
}

/*
    0 1 0 0
    1 1 1 0
    0 1 0 0
    1 1 0 0
*/

