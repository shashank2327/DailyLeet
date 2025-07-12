class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            long leftVal = mid == 0 ? Long.MIN_VALUE : (long)nums[mid - 1];
            long rightVal = mid == n - 1 ? Long.MIN_VALUE : (long)nums[mid + 1];
            long currVal = (long)nums[mid];
            if (currVal > leftVal && currVal > rightVal) {
                return mid;
            } else if (leftVal >= currVal) {
                hi = mid - 1;
            } else if (rightVal >= currVal) {
                lo = mid + 1; 
            }
        }   

        return -1;
    }
}