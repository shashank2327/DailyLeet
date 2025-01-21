class Solution {
    public long gridGame(int[][] grid) {
        long n = grid[0].length;
        long[] rowPrefix = new long[(int)n];
        rowPrefix[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            rowPrefix[i] = rowPrefix[i - 1] + grid[0][i];
        }
        long[] colPrefix = new long[(int)n];
        colPrefix[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            colPrefix[i] = colPrefix[i - 1] + grid[1][i];
        }

        long[] paths = new long[(int)n];

        for (int i = 0; i < n; i++) {
            long left = 0;
            long right = 0;
            if (i > 0) {
                left = colPrefix[i - 1];
            }
            if (i < n - 1) {
                right = rowPrefix[(int)(n - 1)] - rowPrefix[i];
            }
            paths[i] = Math.max(left, right);
        }

        Arrays.sort(paths);
        return paths[0];
    }
}