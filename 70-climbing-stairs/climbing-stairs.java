class Solution {
    public int climbStairs(int n) {
        // int[] memo = new int[n + 1];
        // Arrays.fill(memo, -1);
        // return memoFunction(n, memo);
        return dp(n);
    }

    // Every time I have two options
    // Either to jump one step or to jump 2 step;
    // if numbers of steps i completed through jumping is > n then return 0 if = then retur 1;

    private int recursiveFunction(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        int ways = recursiveFunction(n - 1) + recursiveFunction(n - 2);
        return ways;
    }


    private int memoFunction(int n, int[] memo) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (memo[n] != -1) return memo[n];
        int ways = memoFunction(n - 1, memo) + memoFunction(n - 2, memo);
        memo[n] = ways;
        return memo[n];
    }

    private int dp(int n) {
        int a = 0;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}