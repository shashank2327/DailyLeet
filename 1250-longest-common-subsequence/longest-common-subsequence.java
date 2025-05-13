class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

 /*-----------------------------------------------------------------------------------------------------------*/       
        int[][] memo = new int[n][m];
        for (int[] x : memo) Arrays.fill(x, -1);
        // return f(text1, text2, n - 1, m - 1, memo);
/*------------------------------------------------------------------------------------------------------------*/

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    // Recursive + memo
    private int f(String s1, String s2, int i, int j, int[][] memo) {
        if (i < 0 || j < 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + f(s1, s2, i - 1, j - 1, memo);
            return memo[i][j];
        }

        memo[i][j] = Math.max(f(s1, s2, i - 1, j, memo), f(s1, s2, i, j - 1, memo));
        return memo[i][j];
    }
}