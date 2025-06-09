class Solution {
    public int numSquares(int n) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int root = (int)Math.sqrt(i);
            if (root * root == i) {
                ls.add(i);
            }
        }
        int[][] dp = new int[ls.size() + 1][n + 1];
        for (int j = 1; j <= n; j++) dp[0][j] = Integer.MAX_VALUE;

        for (int i = 1; i <= ls.size(); i++) {
            for (int j = 1; j <= n; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MAX_VALUE;

                if (ls.get(i - 1) <= j) {
                    take = 1 + dp[i][j - ls.get(i - 1)];
                }

                dp[i][j] = Math.min(take, notTake);
            }
        }

        return dp[ls.size()][n];
    }
}