class Solution {
    public int longestOnes(int[] nums, int k) {
        int oneCount = 0;
        int zeroCount = 0;
        
        int n = nums.length;
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < n) {
            if (nums[right] == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                } else {
                    oneCount--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}