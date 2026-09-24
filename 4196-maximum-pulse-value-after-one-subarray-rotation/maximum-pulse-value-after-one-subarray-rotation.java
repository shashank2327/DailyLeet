class Solution {
    public long maxValue(int[] nums) {
        int n = nums.length;

        long actualPulse = 0;
        long[] b = new long[n];

        for (int i = 0; i < n; i++) {
            int val = 2 * nums[i];
            if (i % 2 == 0) {
                b[i] = -val;
                actualPulse += nums[i];
            } else {
                b[i] = val;
                actualPulse -= nums[i];
            }
        }

        long maxChange = maxSubarraySum(b);


        return actualPulse + maxChange;
    }

    private long maxSubarraySum(long[] a) {
        int n = a.length;
        if (n == 1) return 0;

        long[] dp = new long[n];
    
        dp[0] = 0;
        dp[1] = a[0] + a[1];

        for (int i =  2; i < n; i++) {
            dp[i] = Math.max(a[i - 1] + a[i], a[i - 1] + a[i] + dp[i - 2]);
        }

        long max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}