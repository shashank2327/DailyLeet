class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long ans = Integer.MIN_VALUE;
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            ans = Math.max(ans, (totalSum + i)/(i + 1));
        }
        return (int)ans;
    }
}