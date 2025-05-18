class Solution {
    public static final int MOD = (int)(1e9 + 7);
    public int numWays(String[] words, String target) {
        int n = words.length; // number of words I have;
        int m = words[0].length(); // number of columns;
        int[][] mat = new int[26][m];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                mat[words[i].charAt(j) - 'a'][j]++;
            }
        }


        // int[][] memo = new int[m][target.length()];
        // for (int[] row : memo) Arrays.fill(row, -1);
        // return f(mat, target, 0, 0, memo) % MOD;


/*-----------------------------tabulation------------------------------------------------------*/

        int[][] dp = new int[m + 1][target.length() + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][target.length()] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = target.length() - 1; j >= 0; j--) {
                long notTake = dp[i + 1][j];
                long take = 0;
                int c = target.charAt(j) - 'a';
                if (mat[c][i] > 0) {
                    long ways = dp[i + 1][j + 1];
                    take = (mat[c][i] * ways) % MOD;
                }
                dp[i][j] = (int)((take + notTake) % MOD);
            }
        }

        return dp[0][0];

    }


/*---------------------------------memo + recur----------------------------------------------*/

    // i move through column of mat
    // j point on the chracter of target, we are looking for
    private int f(int[][] mat, String target, int i, int j, int[][] memo) {

        // we have traversed the whole target String;
        if (j == target.length()) {
            return 1;
        }
        if (i >= mat[0].length) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        // I have two options 
        // either to take the character from ith column if available or not to take

        long notTake = f(mat, target, i + 1, j, memo);
        long take = 0;
        int c = target.charAt(j) - 'a';
        if (mat[c][i] > 0) {
            long ways = f(mat, target, i + 1, j + 1, memo);
            take = (mat[c][i] * ways) % MOD;
        }

        return memo[i][j] = (int)((take + notTake) % MOD);
    }
}