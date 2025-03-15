class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int bitmask = 0;
        int l = 0;
        int r = 0;
        int max = 0;

        while (r < n) {
            while ((bitmask & nums[r]) != 0) {
                bitmask ^= nums[l];
                l++;
            }

            bitmask = bitmask | nums[r];
            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}