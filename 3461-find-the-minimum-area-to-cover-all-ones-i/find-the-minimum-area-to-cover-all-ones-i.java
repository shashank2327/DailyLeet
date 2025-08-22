class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int maxRow = -1;
        int minRow = Integer.MAX_VALUE;
        int maxCol = -1;
        int minCol = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    maxRow = Math.max(maxRow, i + 1);
                    minRow = Math.min(minRow, i + 1);

                    maxCol = Math.max(maxCol, j + 1);
                    minCol = Math.min(minCol, j + 1);
                }
            }
        }

        return (maxRow - minRow + 1)* (maxCol- minCol + 1);
    }
}

/*
    0 0 1 1

*/