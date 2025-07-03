class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        dfs(image, vis, sr, sc, image[sr][sc], color);

        return image;
    }
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public void dfs(int[][] image, boolean[][] vis, int sr, int sc, int startColor, int color) {
        vis[sr][sc] = true;
        image[sr][sc] = color;
        for (int i = 0; i < 4; i++) {
            int nr = sr + dx[i];
            int nc = sc + dy[i];
            if (nr >= 0 && nc >= 0 && nr < image.length && nc < image[0].length && !vis[nr][nc]
                && image[nr][nc] == startColor
            ) {
                dfs(image, vis, nr, nc, startColor, color);
            }
        }
    }
}