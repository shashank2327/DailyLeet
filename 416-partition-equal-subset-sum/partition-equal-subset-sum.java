class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        return subsetSum(nums, sum / 2);

    }

    private boolean subsetSum(int[] a, int target) {
        int n = a.length;
        
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        Arrays.sort(a);
        if (a[0] > target) return false;
        dp[0][a[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                boolean notTaken = dp[i- 1][j];
                boolean taken = false;
                if (a[i] <= j) {
                    taken = dp[i - 1][j - a[i]];
                }

                dp[i][j] = taken || notTaken;
            }
        }

        return dp[n - 1][target];
    }
}