class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        for (int[] x : memo) Arrays.fill(x, -1);
        return f(nums, -1, 0, memo);
    }

    private int f(int[] nums, int i, int j, int[][] memo) {

        if (j >= nums.length) return 0;

        int take = 0;
        int notTake = 0;
        if (i != -1 && memo[i][j] != -1) return memo[i][j];
        if (i != -1 && nums[j] > nums[i]) {
            take = 1 + f(nums, j, j + 1, memo);
        } else if (i == -1) {
            take = 1 + f(nums, j, j + 1, memo);
        }
        notTake = f(nums, i, j + 1,memo);
        if (i != -1) memo[i][j] = Math.max(take, notTake);
        return Math.max(take, notTake);

    }
}