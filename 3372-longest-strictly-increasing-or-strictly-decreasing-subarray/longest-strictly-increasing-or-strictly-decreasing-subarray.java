class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        
        int maxInc = 0;
        int maxDec = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                maxInc = Math.max(maxInc, count);
                count = 1;
            }
        }
        maxInc = Math.max(count, maxInc);
        count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
            } else {
                maxDec = Math.max(maxDec, count);
                count = 1;
            }
        }
        maxDec = Math.max(count, maxDec);

        return Math.max(maxDec, maxInc);
    }
    // first see what is the max length increasing subarray
}