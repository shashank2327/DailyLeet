class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] memo = new int[n + 1][2002];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, 0, target, memo);
    }

    public int solve(int[] nums, int sum, int idx, int target, int[][] memo) {
        if (idx == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        if (sum < -1000 || sum > 1000) return 0;

        if (memo[idx][sum + 1000] != -1) {
            return memo[idx][sum + 1000];
        }

        int result = 0;

        result += solve(nums, sum + nums[idx], idx + 1, target, memo);
        result += solve(nums, sum - nums[idx], idx + 1, target, memo);

        return memo[idx][sum + 1000] = result;
    }
}