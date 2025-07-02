class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;

        int lo = 0;
        int hi = sum;

        int result = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (possible(nums, k, mid)) {
                result = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }


        return result;
    }

    public boolean possible(int[] nums, int k, int sum) {
        // count the number of subarray such that the sum <= k;
        int cnt = 1;
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > sum) return false;
            if (currSum + nums[i] <= sum) {
                currSum += nums[i];
            } else {
                cnt++;
                currSum = nums[i];
            }
        } 

        if (cnt <= k) {
            return true; 
        } else {
            return false;
        }
    }
}

// Reframe this problem ->
// int ans = x;
// there must be k sub-arrays such that the the sum of subarrays must be lest than x;