class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atLeast(nums, goal) - atLeast(nums, goal - 1);
    }

    public int atLeast(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int count = 0;
        int sum = 0;
        while (r < n) {
            sum += nums[r];
            while (sum > k && l <= r) {
                sum -= nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}