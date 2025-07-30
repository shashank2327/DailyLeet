class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        maxCount = Math.max(maxCount, count);

        return maxCount;
    }
}