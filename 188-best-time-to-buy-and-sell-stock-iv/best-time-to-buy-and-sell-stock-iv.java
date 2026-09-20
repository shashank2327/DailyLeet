class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] memo = new int[n][k + 1][2];

        for (int[][] mat: memo) {
            for (int[] row: mat) {
                Arrays.fill(row, -1);
            }
        }

        return fun(k, prices, 0, n, 1, memo);
    }


    // flag = 1 -> we can buy
    // flag = 0 -> we can sell
    private int fun(int k, int[] prices, int i, int n, int flag, int[][][] memo) {
        if (i == n || k == 0) {
            return 0;
        }

        if (memo[i][k][flag] != -1) return memo[i][k][flag];

        if (flag == 1) {
            // either we skip or we buy;

            int skip = fun(k, prices, i + 1, n, flag, memo);
            int buy = -prices[i] + fun(k, prices, i + 1, n, 1 - flag, memo);

            return memo[i][k][flag] = Math.max(skip, buy);

        } else {
            // either we sell on the ith day or we skip

            int skip = fun(k, prices, i + 1, n, flag, memo);
            int sell = prices[i] + fun(k - 1, prices, i + 1, n, 1 - flag, memo);

            return memo[i][k][flag] = Math.max(skip, sell);

        }
    }
}