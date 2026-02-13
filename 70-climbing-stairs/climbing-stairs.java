class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1]; // each index represent a number of ways to reach that number of steps

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // number i
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
        // return solve(n);
    }   

    // What is the base case
    // What if there is one step : 1 way
    // whay if there is 2 steps : 2 ways
    public int solve(int n) {

        if (n <= 0) return 0;

        if (n == 1 || n == 2) {
            return n;
        }

        // to reach the nth step:
        // either i will come from (n - 1)th step
        // or i will come from (n-2)th step;

        return solve(n - 1) + solve(n - 2);
    }
}