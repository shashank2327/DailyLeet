class Solution {
    public int minDays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0; // if the score is 0, no. of days req = 0;


        for (int i = 1; i <= n; i++) {
            int sum = 0;

            for (int k = 1; k <= n; k++) {
                sum += k;

                if (sum > i) break;

                int rem = i - sum;

                if (rem == 0) {
                    dp[i] = Math.min(dp[i], k);
                } else if (dp[rem] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[rem] + k + 1);
                }
            }
        }

        return dp[n];
    }
}