class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        for (int[] x : memo) Arrays.fill(x, -1);
        return f(s, 0, n - 1, memo);

    }

    private int f(String s, int i, int j,int[][] memo) {
        if (i == j) {
            return 1;
        }
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != -1) return memo[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = 2 + f(s, i + 1, j - 1, memo);
            return memo[i][j];
        }
        memo[i][j] =  Math.max(f(s, i + 1, j, memo), f(s, i, j - 1, memo));
        return memo[i][j];
    }
}