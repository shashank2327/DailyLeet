class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

/*-------------------------------------------------------------------------*/
        int[][] memo = new int[n][m];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }
        // return f(s, t, s.length() - 1, t.length() - 1, memo);

/*-------------------------------------------------------------------------*/

        // Tabulation Code --> Dervied from recursive code;

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }


/*--------------------------recursive + memo-------------------------------------------------*/
    private int f(String s, String t, int i, int j, int[][] memo) {
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return memo[i][j] = f(s, t, i - 1, j - 1, memo) + f(s, t, i - 1, j, memo);
        }

        return memo[i][j] = f(s, t, i - 1, j, memo);
    }
}