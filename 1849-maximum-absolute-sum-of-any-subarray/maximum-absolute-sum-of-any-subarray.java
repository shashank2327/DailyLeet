class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        // Kadane's Algo
        int maxSum = 0;
        int sum = 0;
        for  (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum < 0) {
                sum = 0;
            }

            maxSum = Math.max(maxSum, sum);
        }

        // Reversed Kandane's
        int minSum = 0;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > 0) {
                sum = 0;
            }
            minSum = Math.min(minSum, sum);
        }


        int ans = Math.max(Math.abs(minSum), maxSum);

        return ans;
    }
}