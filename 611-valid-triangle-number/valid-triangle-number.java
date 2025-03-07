class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int i = n - 1; i >= 2; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (nums[j] + nums[k] > nums[i]) {
                    count += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }

        return count;
    }
}