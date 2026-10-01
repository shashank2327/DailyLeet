class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n + 1][n + 1];

        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return solve(nums, -1, 0, n, memo);
    }

    public int solve(int[] nums, int i, int j, int n, int[][] memo) {
        if (j == n) {
            return 0;
        }

        if (memo[i + 1][j + 1] != -1) return memo[i + 1][j + 1];

        // Either I take it or I do not take it
        int notTake = solve(nums, i, j + 1, n, memo);


        int take = 0;

        if (i == -1) {
            take = 1 + solve(nums, j, j + 1, n, memo);
        } else if (nums[j] > nums[i]) {
            take = 1 + solve(nums, j, j + 1, n, memo);
        }

        return memo[i + 1][j + 1] = Math.max(take, notTake);
    }
}