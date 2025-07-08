class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(nums, -1, 0, memo);
    }

    public int solve(int[] nums, int prevIdx, int currIdx, int[][] memo) {
        if (currIdx == nums.length) {
            return 0;
        }
        if (memo[prevIdx + 1][currIdx + 1] != -1) {
            return memo[prevIdx + 1][currIdx + 1];
        }
        int ans = 0;
        // take it
        if (prevIdx == -1 || nums[prevIdx] < nums[currIdx]) {
            ans = Math.max(ans, 1 + solve(nums, currIdx, currIdx + 1, memo));
        }

        // do not take it;
        ans = Math.max(ans, solve(nums, prevIdx, currIdx + 1, memo));


        return memo[prevIdx + 1][currIdx + 1] = ans;
    }
}