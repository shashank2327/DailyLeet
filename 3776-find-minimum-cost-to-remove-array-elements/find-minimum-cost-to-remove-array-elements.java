class Solution {
    public int minCost(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] num : dp) {
            Arrays.fill(num, -1);
        }
        return solve(nums, 0, 1, dp);
    }


    private int solve(int[] nums, int prevIdx, int idx, int[][] dp) {

        if (idx == nums.length) return nums[prevIdx];
        if (idx == nums.length - 1) return Math.max(nums[prevIdx], nums[idx]);
        if (dp[idx][prevIdx] != -1) return dp[idx][prevIdx];

        int case1 = Math.max(nums[idx], nums[idx + 1]) + solve(nums, prevIdx, idx + 2, dp);
        int case2 = Math.max(nums[prevIdx], nums[idx]) + solve(nums, idx + 1, idx + 2, dp);
        int case3 = Math.max(nums[prevIdx], nums[idx + 1]) + solve(nums, idx, idx + 2, dp);

        return dp[idx][prevIdx] = Math.min(case1, Math.min(case2, case3));
    }
}