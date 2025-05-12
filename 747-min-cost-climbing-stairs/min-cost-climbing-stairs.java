class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            int way1 = dp[i - 1] + cost[i];
            int way2 = dp[i - 2] + cost[i];
            dp[i] = Math.min(way1, way2);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
    
}