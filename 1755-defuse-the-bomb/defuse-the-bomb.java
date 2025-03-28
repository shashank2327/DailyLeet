class Solution {
    public int[] decrypt(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];

        if (k == 0) return ans;

        if (k > 0) {

            int sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += nums[i];
            }

            int nextIdx = (k + 1) % n;
            int currIdx = 1;

            for (int i = 0; i < n; i++) {
                ans[i] = sum;
                sum += nums[nextIdx] - nums[currIdx];
                nextIdx = (nextIdx + 1) % n;
                currIdx = (currIdx + 1) % n;
            }
            return ans;

        } else {
            int k1 = Math.abs(k);
            int sum = 0;

            for (int i = n - 1; i >= n - k1; i--) {
                sum += nums[i];
            }

            int nextIdx = n + k;
            int currIdx = 0;

            for (int i = 0; i < n; i++) {
                ans[i] = sum;
                sum = sum - nums[nextIdx] + nums[currIdx];
                nextIdx = (nextIdx + 1 + n) % n;
                currIdx = (currIdx + 1 + n) % n;
            }

            return ans;
        }
    }
}