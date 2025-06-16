class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num : nums) sum += num;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = sum - nums[i];

        int max = 0;
        for (int i = 0; i < n; i++) {
            max += i * nums[i];
        }
        int prevCal = max;
        for (int i = 1; i < n; i++) {
            int prev = i - 1;
            int score = nums[prev] * (n - 1) + prevCal - dp[prev];
            prevCal = score;
            max = Math.max(score, max);
        }

        return max;
    }
}