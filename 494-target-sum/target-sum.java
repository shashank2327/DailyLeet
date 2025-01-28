class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int max = 0;

        for (int num : nums) {
            max += num;
        }

        if (target > max || target < -max) return 0;

        int[][] dp = new int[n][(2*max) + 1];

        for (int[] a : dp) {
            Arrays.fill(a, Integer.MIN_VALUE);
        }

        return totalWays(max, nums, 0, target, 0, dp);
    }

    public int totalWays(int max, int[] nums, int ind, int target, int currentVal, int[][] dp) {

        if (ind == nums.length) {
            if (currentVal == target) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[ind][currentVal + max] != Integer.MIN_VALUE) return dp[ind][currentVal + max];


        dp[ind][currentVal + max] = totalWays(max, nums, ind + 1, target, currentVal + nums[ind], dp) + 
                totalWays(max , nums, ind + 1, target, currentVal - nums[ind], dp);

        return dp[ind][currentVal + max];
    }
}