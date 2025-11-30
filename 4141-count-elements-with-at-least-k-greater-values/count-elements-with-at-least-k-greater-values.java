class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) return n;

        int greaterCount = 0;

        Arrays.sort(nums);
        int result = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                greaterCount = n - i - 1;
            }
            if (greaterCount >= k) result++;
        }

        return result;
    }
}