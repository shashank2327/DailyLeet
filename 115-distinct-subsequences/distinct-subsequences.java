class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] memo = new int[n + 1][m + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(s, t, 0, 0, memo);
    }

    public int solve(String s, String t, int i, int j, int[][] memo) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int result = 0;

        // if matches;
        // I have two options. Either take it or do not take it;
        if (s.charAt(i) == t.charAt(j)) {
            // take;
            result += solve(s, t, i + 1, j + 1, memo);
        //     // not take;
        //     result += solve(s, t, i + 1, j, memo);
        // } else {
            
        }
        result += solve(s, t, i + 1, j, memo);

        return memo[i][j] = result;
    }
}