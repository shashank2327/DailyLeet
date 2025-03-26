class Solution {
    public int minOperations(int[][] grid, int x) {

        int n = grid.length;
        int m = grid[0].length;
        int[] a = new int[m * n];


        boolean flag = false;
        int val = grid[0][0] % x;

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] % x != val) flag = true;
                a[idx] = grid[i][j];
                idx++;
            }
        }

        if (flag) return -1;


        int len = a.length;
        Arrays.sort(a);
        val = a[len / 2];

        int ans = 0;

        for (int i = 0; i < len; i++) {
            ans += Math.abs(val - a[i]) / x;
        }

        return ans;
    }
}