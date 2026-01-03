class Solution {

    private static final int MOD = 1_000_000_007;
    private int[][][][] dp;


    private int solve(int i, int n, int a, int b, int c) {
        if (i == n) return 1;

        if (dp[i][a][b][c] != -1) {
            return dp[i][a][b][c];
        }

        int ans = 0;

        for (int j = 1; j <= 3; j++) {
            if (a == j) continue;

            for (int k = 1; k <= 3; k++) {
                if (b == k || j == k) continue;

                for (int l = 1; l <= 3; l++) {
                    if (c == l || k == l) continue;

                    ans = (ans + solve(i + 1, n, j, k, l)) % MOD;
                }
            }
        }

        dp[i][a][b][c] = ans;

        return ans;
    }

    public int numOfWays(int n) {
        dp = new int[n][4][4][4];

        for (int i = 0; i < n; i++) {
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    Arrays.fill(dp[i][a][b], -1);
                }
            }
        }

        return solve(0, n, 0, 0, 0);
    }
}