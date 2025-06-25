class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
	int max = -1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			max = Math.max(max, grid[i][j]);	
		}
}
int lo = 0;
int hi = max;
int result = -1;
while (lo <= hi) {
		int mid = lo + (hi - lo)/ 2;
		boolean flag = bfs(grid, mid);
		if ( flag ) {
			result = mid;
			hi = mid - 1;
		} else {
			lo = mid + 1;
		}
}

return result;

    }

    public boolean bfs(int[][] grid, int mid) {
	if (mid < grid[0][0]) return false;
	int n = grid.length;
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, 1, -1};
	Queue<int[]> q = new LinkedList<>(); // it will store row and col;
	boolean[][] vis = new boolean[n][n];
	q.offer(new int[]{0, 0});
	vis[0][0] = true;
	
	while (!q.isEmpty()) {
		int[] it = q.poll();
		int row = it[0];
		int col = it[1];
		

		if (row == n -1 && col == n - 1) return true;
		
		// traverse in all 4 directions
		for (int i = 0; i < 4; i++) {
			int nr = row + dx[i];
			int nc = col + dy[i];
			if (nr >= 0 && nc >= 0 && nc < n && nr < n && grid[nr][nc] <= mid 
	&& !vis[nr][nc]
) {
				vis[nr][nc] = true;
				q.offer(new int[]{nr, nc});
			}
		}	
		
}

return false;
}

}