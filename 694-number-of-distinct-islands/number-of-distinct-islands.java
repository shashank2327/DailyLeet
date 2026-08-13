class Solution {

    private void dfs(int row, int col, int[][] vis, int[][] grid, 
        List<String> vec, int row0, int col0) {
        vis[row][col] = 1;
        vec.add(toString(row - row0, col-col0));
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1 && vis[nr][nc] == 0) {
                dfs(nr, nc, vis, grid, vec, row0, col0);
            }
        }
    }

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    public int numDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        Set<List<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    List<String> vec = new ArrayList<>();
                    dfs(i, j, vis, grid, vec, i, j);
                    set.add(vec);
                }
            }
        }

        return set.size();
    }
}