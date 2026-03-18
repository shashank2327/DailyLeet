class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] pSum = new int[n][m];
        pSum[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                int val = grid[i][j];
                if (i == 0) {
                    pSum[i][j] = val + pSum[i][j - 1];
                } else if (j == 0) {
                    pSum[i][j] = val + pSum[i - 1][j]; 
                } else {
                    pSum[i][j] = pSum[i - 1][j] + pSum[i][j - 1] + val - pSum[i - 1][j - 1];
                }
            }
        }

        int cnt = 0;
        // for (int[] row : pSum) {
        //     System.out.println(Arrays.toString(row));
        // }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pSum[i][j] <= k) cnt++;
            }
        }

        return cnt;
    }
}