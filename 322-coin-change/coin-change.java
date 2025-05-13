class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] <= j) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                }
            }
        }

        return dp[amount] == (int)1e9 ? -1 : dp[amount];
    }
}