class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int lo = 1;
        int hi = (int)1e7;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (check(nums, threshold, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    public boolean check(int[] nums, int threshold, int mid) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] + mid - 1) /mid;
        }

        if (sum <= threshold) {
            return true;
        } else {
            return false;
        }
    }
}