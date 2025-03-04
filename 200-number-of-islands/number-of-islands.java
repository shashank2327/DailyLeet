class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}



class Solution {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int cnt = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }

    private void bfs(int ro, int co, int[][] vis, char[][] grid) {
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;


        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            // up
            int ru = row  - 1;
            if (ru >= 0 && grid[ru][col] == '1' && vis[ru][col] == 0) {
                vis[ru][col] = 1;
                q.add(new Pair(ru, col));
            }
            // down
            int rd = row + 1;
            if (rd < n && grid[rd][col] == '1' && vis[rd][col] == 0) {
                vis[rd][col] = 1;
                q.add(new Pair(rd, col));
            }
            // left
            int cl = col - 1;
            if (cl >= 0 && grid[row][cl] == '1' && vis[row][cl] == 0) {
                vis[row][cl] = 1;
                q.add(new Pair(row, cl));
            }
            // right
            int cr = col + 1;
            if (cr < m && grid[row][cr] == '1' && vis[row][cr] == 0) {
                vis[row][cr] = 1;
                q.add(new Pair(row, cr));
            }
        }
    }
}