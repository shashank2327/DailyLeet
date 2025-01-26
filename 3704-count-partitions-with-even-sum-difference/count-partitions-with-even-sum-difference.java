class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] pSum = new int[nums.length];
        pSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pSum[i] = pSum[i - 1] + nums[i];
        }

        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            int leftSum = pSum[i];
            int rightSum = pSum[n - 1] - pSum[i];
            if (Math.abs(leftSum - rightSum) % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}