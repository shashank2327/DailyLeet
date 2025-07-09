class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }

    public int solve(int[] nums, int sum, int idx, int target) {
        if (idx == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int result = 0;

        result += solve(nums, sum + nums[idx] , idx + 1, target);
        result += solve(nums, sum - nums[idx], idx + 1, target);

        return result;
    }
}