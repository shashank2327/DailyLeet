class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] memo = new int[n][2];
        for (int[] x : memo) {
            Arrays.fill(x, Integer.MIN_VALUE);
        }
        // return f(prices, 0, 1, memo, fee);
        return stockProfit(prices, fee);
    }

    private int f(int[] prices, int i, int bs, int[][] memo , int fee) {
        if (i >= prices.length) {
            return 0;
        }
        if (memo[i][bs] != Integer.MIN_VALUE) return memo[i][bs];

        if (bs == 1) {
            return memo[i][bs] =  Math.max(
                -prices[i] + f(prices, i + 1, 0, memo, fee),
                f(prices, i + 1, 1, memo, fee)
            );
        } else {
            return memo[i][bs] = Math.max(
                prices[i] + f(prices, i + 1, 1, memo, fee) - fee,
                f(prices, i + 1, 0, memo, fee)
            );
        }
    }


    private int stockProfit(int[] Arr, int fee) {
        int n = Arr.length;
        int dp[][] = new int[n + 1][2];
        
        // Iterate through the array backwards
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], Arr[ind] + dp[ind + 1][0] - fee);
                }

                dp[ind][buy] = profit;
            }
        }

        // The maximum profit is stored in dp[0][0]
        return dp[0][0];
    }
}