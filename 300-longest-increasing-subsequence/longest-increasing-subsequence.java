class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
/*-------------------------------------------------------------------------------------------*/        
        int[][] memo = new int[n + 1][n];
        for (int[] x : memo) Arrays.fill(x, -1);
        // return f(nums, -1, 0, memo);
/*-------------------------------------------------------------------------------------------*/  

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int i = 1;
        int max = 0;
        int[] hash = new int[n];
        for (int k = 0; k < n; k++) hash[k] = k;
        while (i != n) {
            int j = 0;
            while (j < i) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
                j++;
            }
            i++;
        }

        // Printing LIS
        int hashIndex = -1;
        for (int k = 0; k < n; k++) {
            if (dp[k] > max) {
                max = dp[k];
                hashIndex = k;
            }
        }

        int[] printLIS = new int[max];
        for (int k = max - 1; k >= 0; k--) {
            printLIS[k] = nums[hashIndex];
            hashIndex = hash[hashIndex];
        }
        System.out.println(Arrays.toString(printLIS));
        return max;
    }

/*--------------------------memo + rec-------------------------------------------------------*/
    private int f(int[] nums, int i, int j, int[][] memo) {
        if (j == nums.length) return 0;
        if (memo[i + 1][j] != -1) return memo[i + 1][j];
        int take = 0;
        if (i == -1 || nums[j] > nums[i]) {
            take = 1 + f(nums, j, j + 1, memo);
        }
        int notTake = f(nums, i, j + 1,memo);
        return memo[i + 1][j] = Math.max(take, notTake);
    }
}