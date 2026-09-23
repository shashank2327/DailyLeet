class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
        int n = nums.length;
        long plus = nums[0];
        long minus = -(long)1e9;

        long max = Math.max(plus, minus);

        for (int i = 1; i < n; i++) {
            long newP = Math.max(minus + nums[i], nums[i]);
            long newM = plus - nums[i];

            plus = newP;
            minus = newM;

            max = Math.max(max, Math.max(plus, minus));
        }

        return max;
    }
}