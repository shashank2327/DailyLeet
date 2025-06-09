class Solution {
    private int r;
    private int c;
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        boolean[][] vis = new boolean[n][m];

        List<int[]> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !vis[i][j]) {
                    r = Integer.MIN_VALUE;
                    c = Integer.MIN_VALUE;
                    dfs(land, i, j, vis, n, m);
                    int[] a = {i, j, r, c};
                    ls.add(a);
                }
            }
        }


        int len = ls.size();
        int[][] res = new int[len][4];
        for (int i = 0; i < len; i++) {
            res[i] = ls.get(i);
        }

        return res;
    }

    private void dfs(int[][] land, int i, int j, boolean[][] vis, int n, int m) {
        vis[i][j] = true;
        r = Math.max(r, i);
        c = Math.max(c, j);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int k = 0; k < 4; k++) {
            int nr = i + dx[k];
            int nc = j + dy[k];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && land[nr][nc] == 1 && !vis[nr][nc]) {
                dfs(land, nr, nc, vis, n, m);
            }
        }

    }
}