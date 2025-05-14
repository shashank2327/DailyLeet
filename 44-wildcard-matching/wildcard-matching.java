class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] memo = new int[n][m];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }
        return f(s, p, n - 1, m - 1, memo);
    }

    private boolean f(String s, String t, int i, int j, int[][] memo) {
        
        if (i < 0) {
            while (j >= 0) {
                if (t.charAt(j) != '*') {
                    return false;
                }
                j--;
            }
            return true;
        }
        if (j < 0) return false;


        if (memo[i][j] != -1) {
            return memo[i][j] == 0 ? false : true;
        }

        if (s.charAt(i) == t.charAt(j) || t.charAt(j) == '?') {
            memo[i][j] = f(s, t, i - 1, j - 1, memo) == true ? 1 : 0;
            return f(s, t, i - 1, j - 1, memo);
        }
        if (s.charAt(i) != t.charAt(j) && t.charAt(j) != '*') return false;

        memo[i][j] = (f(s, t, i - 1, j, memo) || f(s, t, i, j - 1, memo)) == true ? 1 : 0;
        return memo[i][j] == 1 ? true : false;
    }
}