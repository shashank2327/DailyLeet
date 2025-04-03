class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];
        int max = nums[0];
        int min = nums[1];
        diff[1] = max - min;
        for (int i = 2; i < n; i++) {
            max = Math.max(nums[i - 1], max);
            min = nums[i];
            diff[i] = Math.max(diff[i - 1], max - min);
        }

        int[] maxK = new int[n];
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, nums[i]);
            maxK[i] = max;
        }

        long ans = 0;

        for (int i = 2; i < n; i++) {
            long currVal = (long) diff[i - 1] * maxK[i];
            ans = Math.max(currVal, ans);
        }

        return ans;
    }
}