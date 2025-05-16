class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] bal = new int[n + 2];
        bal[0] = 1;
        bal[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            bal[i] = nums[i - 1];
        }
        // return f(1, n, bal);

/*------------------------------tabulation-----------------------------------------------*/
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int max = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int coins = bal[i - 1] * bal[ind] * bal[j + 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    max = Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }

    private int f(int i, int j, int[] bal) {
        if (i > j) {
            return 0;
        }    
        int max = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int coins = bal[i - 1] * bal[ind] * bal[j + 1] + f(i, ind - 1, bal) + f(ind + 1, j, bal);
            max = Math.max(max, coins); 
        }
        return max;
    }
}