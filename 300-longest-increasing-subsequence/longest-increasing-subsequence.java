class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n + 1][n];
        for (int[] x : memo) Arrays.fill(x, -1);
        return f(nums, -1, 0, memo);
    }

    private int f(int[] nums, int i, int j, int[][] memo) {
        if (j == nums.length) return 0;
        if (memo[i + 1][j] != -1) return memo[i + 1][j];
        int take = 0;
        if (i == -1 || nums[j] > nums[i]) {
            take = 1 + f(nums, j, j + 1, memo);
        }
        int notTake = f(nums, i, j + 1,memo);
        return memo[i + 1][j] = Math.max(take, notTake);

    }
}