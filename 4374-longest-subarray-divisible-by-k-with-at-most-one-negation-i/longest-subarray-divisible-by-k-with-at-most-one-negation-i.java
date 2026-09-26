class Solution {
    public int longestSubarray(int[] nums, int k) {
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Long> set = new HashSet<>();
            long curr_sum = 0;
            for (int j = i; j < n; j++) {
                curr_sum += nums[j];
                long change = ((long) (2 * nums[j]) % k + k) % k;
                set.add(change);

                long sum = (curr_sum % k + k) % k;
                if (sum == 0 || set.contains(sum)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }
}