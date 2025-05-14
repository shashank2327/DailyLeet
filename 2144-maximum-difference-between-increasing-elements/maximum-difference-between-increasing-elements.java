class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        int[] max = new int[n];

        min[0] = nums[0];
        max[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], nums[i]);
        }
        int maxDiff = -1;
        for (int i = 0; i < n - 1; i++) {
            maxDiff = Math.max(maxDiff, max[i + 1] - min[i]);
        }
        return maxDiff == 0 ? -1 : maxDiff;
    }
}