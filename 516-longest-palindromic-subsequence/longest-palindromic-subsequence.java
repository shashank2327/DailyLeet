class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return memo(s, 0, n - 1, n, dp);
    }

    private int memo(String s, int l, int h, int n, int[][] dp) {

        if (l >= n || h < 0) {
            return 0;
        }

        if (dp[l][h] != -1) return dp[l][h];

        if (s.charAt(l) == s.charAt(h)) {
            dp[l][h] =  1 + memo(s, l + 1, h - 1, n, dp);
            return dp[l][h];
        } else {
            dp[l][h] = Math.max(memo(s, l + 1, h, n, dp), memo(s, l, h - 1, n, dp));
            return dp[l][h];
        }
    }
}