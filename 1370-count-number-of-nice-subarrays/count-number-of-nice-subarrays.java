class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] % 2;
        }

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

// reframe the problem ->

/*
    1, 1, 2, 1, 1; k = 3



    1, 1, 0, 1, 1;

    Number of subarrays whose sum is  k;


*/