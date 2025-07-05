class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int left = -1;
            int right = 0;
            while (right < m) {
                if (left == -1) {
                    if (grid[i][right] == 1) {
                        cnt++;
                    }
                } else {
                    if (grid[i][left] == 0 && grid[i][right] == 1) {
                        cnt++;
                    } else if (grid[i][left] == 1 && grid[i][right] == 0) {
                        cnt++;
                    }
                }
                left++;
                right++;
            }

            if (left == m - 1 && grid[i][left] == 1) cnt++; 
        }


        for (int j = 0; j < m; j++) {
            int left = -1;
            int right = 0;
            while (right < n) {
                if (left == -1) {
                    if (grid[right][j] == 1) {
                        cnt++;
                    }
                } else {
                    if (grid[left][j] == 0 && grid[right][j] == 1) {
                        cnt++;
                    } else if (grid[left][j] == 1 && grid[right][j] == 0) {
                        cnt++;
                    }
                }
                left++;
                right++;
            }

            if (left == n - 1 && grid[left][j] == 1) cnt++; 
        }

        return cnt;
    }
}

/*
    0 1 0 0
    1 1 1 0
    0 1 0 0
    1 1 0 0
*/