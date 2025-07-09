class Solution {
    public int numTrees(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            int ways = 0;
            for (int j = 1; j <= i; j++) {
                int leftWays = dp[j - 1];
                int rightWays = dp[i - j];
                ways += leftWays * rightWays;
            }
            dp[i] = ways;
        }

        return dp[n];
    }
}


// i we have n node;

// if we put nth node as the head, then number of nodes on left and right would be?
// similary, if we put (n - 1)th node as the head, then the number of nodes on left and right would be?