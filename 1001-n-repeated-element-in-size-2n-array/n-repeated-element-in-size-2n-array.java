class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int idx = n/2;

        if (nums[idx] == nums[idx+1]) {
            return nums[idx];
        }

        return nums[idx-1];
    }
}