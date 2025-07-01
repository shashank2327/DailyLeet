class Solution {
    public int minXor(int[] nums, int k) {
        int n = nums.length;
        int[][] memo = new int[n + 1][k + 1];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }
        return solve(0, k, n, nums, memo);
    }

    public int solve(int i, int k, int n, int[] nums, int[][] memo) {
        if (k == 0 && i < n) return Integer.MAX_VALUE;
        if (k == 0 && i >= n) return 0;

        if (memo[i][k] != -1) {
            return memo[i][k];
        }

        int ans = Integer.MAX_VALUE;
        int xor = 0;
        for (int j = i; j < n; j++) {
            xor = (xor ^ nums[j]);

            ans = Math.min(ans, Math.max(xor, solve(j + 1, k - 1, n, nums, memo)));
        }

        return memo[i][k] = ans;
    }
}