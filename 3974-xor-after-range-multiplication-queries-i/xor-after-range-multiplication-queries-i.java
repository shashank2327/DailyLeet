class Solution {
    private static final int MOD = (int) (1e9 + 7);
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];

            while (l <= r) {
                 nums[l] = (int)(((long) nums[l] * v) % MOD);
                l += k;
            }
        }
        int val = 0;
        for (int i = 0; i < n; i++) {
            val = val ^ nums[i];
        }

        return val;
    }
}