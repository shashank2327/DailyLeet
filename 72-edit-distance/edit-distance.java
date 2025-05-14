class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

/*--------------------------------------------------------------------------------------*/
        int[][] memo = new int[n][m];
        for (int[] x : memo) Arrays.fill(x, -1);
        return f(word1, word2, n - 1, m - 1, memo);
    }

/*-----------------------recursive + memo-------------------------------------------------*/
    private int f(String s, String t, int i, int j, int[][] memo) {
        if (j < 0) return i + 1;
        if (i < 0) return j + 1;
        if (memo[i][j] != -1) return memo[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return memo[i][j] = f(s, t, i - 1, j - 1, memo);
        }

        int insert = 1 + f(s, t, i, j - 1, memo);
        int replace = 1 + f(s, t, i - 1, j - 1, memo);
        int delete = 1 + f(s, t, i - 1, j, memo);

        return memo[i][j] = Math.min(insert, Math.min(replace, delete));
    }
}