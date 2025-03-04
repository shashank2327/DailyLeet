class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        int[][] ans = new int[n][m];
        for (int i  = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = image[i][j];
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        dfs(sr, sc, ans, image, color, dx, dy, iniColor);
        return ans;
    }

    private void dfs
    (
        int row, 
        int col, 
        int[][] ans, 
        int[][] image, 
        int color,
        int[] dx, 
        int[] dy,
        int iniColor
    ) {
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if (nrow >= 0 && ncol >= 0 && ncol < m && nrow < n &&
                image[nrow][ncol] == iniColor && ans[nrow][ncol] != color
            ) {
                dfs(nrow, ncol, ans, image, color, dx, dy, iniColor);
            }
        }
    }
}