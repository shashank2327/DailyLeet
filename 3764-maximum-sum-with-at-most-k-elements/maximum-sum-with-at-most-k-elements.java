class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int len = m * n;
        int[][] mat = new int[len][2];
        int ind = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[ind][0] = grid[i][j];
                mat[ind][1] = i;
                ind++;
            }
        }
        Arrays.sort(mat, Comparator.comparingInt(a -> a[0]));
        ind = n * m - 1;
        long sum = 0;
        while (k > 0) {
            int i = mat[ind][1];
            if (limits[i] > 0) {
                sum += mat[ind][0];
                limits[i]--;
                k--;
            }
            ind--;
        }
        return sum;
    }
}