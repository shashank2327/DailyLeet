class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int bits = maxVal == 0 ? 0 : 1 + (int)(Math.log(maxVal) / Math.log(2));

        int[] nearest_setbit = new int[bits];
        Arrays.fill(nearest_setbit, n);
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            int nearest = i;
            for (int j = 0; j < bits; ++j) {
                if ((nums[i] & (1 << j)) != 0) {
                    nearest_setbit[j] = i;
                } else if (nearest_setbit[j] != n) {
                    nearest = Math.max(nearest, nearest_setbit[j]);
                }
            }
            ans[i] = nearest - i + 1;
        }
        return ans;
    }
}