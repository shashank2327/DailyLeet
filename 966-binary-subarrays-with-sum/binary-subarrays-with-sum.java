class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        int n = nums.length;
        int count = 0; // count of the subarray;
        int sum = 0; // keeps track of current sum;

        // pointers
        int left = 0;
        int right = 0;

        while (right < n) {
            sum += nums[right];
            while (sum > k && left <= right) {
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
            right++;
        }
        return count;
    }
}

// sliding window is usefull when the required event increases or decreases in a particular directions

/*
*/