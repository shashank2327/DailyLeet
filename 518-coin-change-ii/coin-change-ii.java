class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n + 1][amount + 1];


        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int notTake = dp[i - 1][j];

                int take = 0;
                if (coins[i - 1] <= j) {
                    take = dp[i][j - coins[i - 1]];
                }

                dp[i][j] = take + notTake;
            }
        }

        return dp[n][amount];
    }
}

/*
    Base case:

    1. if the amount is 0, number of ways = 1;
    2. if the amount is x, there is no coins , number of ways = 0
*/