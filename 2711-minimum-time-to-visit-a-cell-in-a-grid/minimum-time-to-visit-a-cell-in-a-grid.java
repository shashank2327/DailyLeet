class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int m = grid.length,  n = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int time = curNode[0], curRow = curNode[1], curCol = curNode[2];

            if (curRow == m-1 && curCol == n - 1) return time;
            if (vis[curRow][curCol]) continue;
            vis[curRow][curCol] = true;

            for (int[] dir : dirs) {
                int nr = curRow + dir[0], nc = curCol + dir[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !vis[nr][nc]) {
                    int cycle = (Math.abs(grid[nr][nc] - time) % 2 == 0) ? 1 : 0;
                    pq.add(new int[]{Math.max(grid[nr][nc] + cycle, time + 1), nr, nc});
                }
            }
        }
        return -1;
    }
}