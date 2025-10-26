class Solution {
    private static final int MOD = 1000000007;

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int fun(int idx, int g, int[][] mat, int[][] dp) {
        int m = mat.length;

        if (idx == m) {
            return (g == 1) ? 1 : 0;
        }


        if (dp[idx][g] != -1) return dp[idx][g];


        long res = 0;

        for (int i = 0; i < mat[idx].length; i++) {
            int value = mat[idx][i];
            int newg;

            if (idx == 0) {
                newg = value;
            } else {
                newg = gcd(g, value);
            }

            res = (res + fun(idx + 1, newg, mat, dp)) % MOD;
        }

        dp[idx][g] = (int) res;
        return dp[idx][g];
    }

    public int countCoprime(int[][] mat) {
        int m = mat.length;

        if (m == 0) return 0;

        int[][] dp = new int[m][151];
        for (int[] row : dp) Arrays.fill(row, -1);

        return fun(0, 0, mat, dp);
    }
}

/*
    1 2
    3 4
*/