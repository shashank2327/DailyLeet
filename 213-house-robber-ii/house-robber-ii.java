class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int val1 = func(nums, 0, n - 1);
        int val2 = func(nums, 1, n);
        return Math.max(val1, val2);
    }
    public int func(int[] nums, int start, int end) {
        int n = start - end;
        if (n == 1) return nums[start];

        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i < end; i++) {
            int leave = dp[i - 1];
            int rob = nums[i] + dp[i - 2];
            dp[i] = Math.max(leave, rob);
        }
        return dp[end - 1];
    }
}