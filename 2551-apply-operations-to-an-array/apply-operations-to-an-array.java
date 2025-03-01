class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int j = 1; j < n; j++) {
            if (nums[j - 1] == nums[j]) {
                nums[j - 1] = nums[j - 1] * 2;
                nums[j] = 0;
            }
        }

        int l = 0;
        int r = n - 1;

        for (int num : nums) {
            if (num == 0) {
                result[r] = 0;
                r--;
            } else {
                result[l] = num;
                l++;
            }
        }

        return result;
    }
}