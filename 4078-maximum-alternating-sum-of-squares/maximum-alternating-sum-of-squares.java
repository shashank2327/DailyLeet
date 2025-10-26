class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);
        long result = 0;

        for (int i = 0; i < n/2; i++) {
            result -= (nums[i] * nums[i]);
        }

        for (int i = n/2; i < n; i++) {
            result += (nums[i] * nums[i]);
        }


        return result;
    }
}