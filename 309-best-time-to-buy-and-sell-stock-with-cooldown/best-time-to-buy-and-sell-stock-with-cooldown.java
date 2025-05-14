class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n][2];
        for (int[] x : memo) {
            Arrays.fill(x, Integer.MIN_VALUE);
        }
        return f(prices, 0, 1, memo);

    }

    private int f(int[] prices, int i, int bs, int[][] memo) {
        if (i >= prices.length) {
            return 0;
        }
        if (memo[i][bs] != Integer.MIN_VALUE) return memo[i][bs];
        if (bs == 1) {
            return memo[i][bs] =  Math.max(
                -prices[i] + f(prices, i + 1, 0, memo),
                f(prices, i + 1, 1, memo)
            );
        } else {
            return memo[i][bs] = Math.max(
                prices[i] + f(prices, i + 2, 1, memo),
                f(prices, i + 1, 0, memo)
            );
        }
    }
}