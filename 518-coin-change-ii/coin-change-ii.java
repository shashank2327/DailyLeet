class Solution {
    
    public int change(int x, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][x + 1];
        Arrays.sort(coins);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= x; j++) {
                int skip = dp[i + 1][j];
                int pick = 0;
                if (coins[i] <= j) {
                    pick = dp[i][j - coins[i]];
                }
                dp[i][j] = (skip + pick);
            }
        }
        return dp[0][x];
    }
}