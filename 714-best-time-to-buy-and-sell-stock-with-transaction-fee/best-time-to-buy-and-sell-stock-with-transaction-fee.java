class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] memo = new int[n][2];
        for (int[] x : memo) {
            Arrays.fill(x, Integer.MIN_VALUE);
        }
        return f(prices, 0, 1, memo, fee);
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
}