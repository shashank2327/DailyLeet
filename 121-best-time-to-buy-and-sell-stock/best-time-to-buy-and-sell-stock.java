class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] > min) ans = Math.max(ans, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return ans;
    }
}