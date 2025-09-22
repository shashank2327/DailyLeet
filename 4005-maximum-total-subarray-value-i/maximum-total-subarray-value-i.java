class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }   

        long val = (long)k * (max - min);

        return val;
    }
}