class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] memo = new int[n][m];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }
        return f(s, t, s.length() - 1, t.length() - 1, memo);
    }

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