class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);

        for (int i = 2; i < n; i++) {
            int robTheHouse = nums[i] + dp[i - 2];
            int doNotRob = dp[i - 1];
            dp[i] = Math.max(robTheHouse, doNotRob);
        }

        return dp[n - 1];
    }
}

// [2, 7, 9, 3, 1];

// [2, 7, 11, 10, 12]

// [2, 7, 1, 1, 15];

// [2, 7, 7, 8, 22]