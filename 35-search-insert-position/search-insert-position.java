class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, result = nums.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m - 1;
                result = m;
            } else {
                l = m + 1;
            }
        }

        return result;
    }
}