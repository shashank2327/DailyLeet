class Solution {
    final static int MOD = (int)1e9 + 7;
    public int maxSum(List<Integer> nums, int k) {
        int[] cnt = new int[30];

        for (int num: nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    cnt[i]++;
                }
            }
        }

        long res = 0;

        for (int i = 0; i < k; i++) {
            long curr = 0;

            for (int j = 29; j >= 0; j--) {
                if (cnt[j] > 0) {
                    curr = curr | (1L << j);
                    cnt[j]--;
                }
            }

            res = (res + curr * curr) % MOD;
        }

        return (int) res;
    }
}