class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int)1e9);

        dp[0] = 0; // if the amount is 0, the number of coins required = 0;


        for (int i = 1; i <= amount; i++) {
            int amt = i;
            for (int coin: coins) {
                if (coin <= amt) {
                    dp[amt] = Math.min(dp[amt], dp[amt - coin] + 1);
                }
            }
        }

        return dp[amount] == (int)1e9 ? -1 : dp[amount];
    }
}


/*
        This is question is same as "frog jump with k steps".

        from every position I can take any k steps.
*/