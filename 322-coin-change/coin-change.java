class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n + 1][amount + 1];
        for (int[] x : dp) {
            Arrays.fill(x, (int)1e9);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                }
            }
        }

        return dp[n][amount] == (int)1e9 ? -1 : dp[n][amount];
    }
}