class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n  = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int i = 1;
        int max = 0;
        int[] hash = new int[n];

        while (i != n) {
            int j = 0;
            while (j < i) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
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

        List<Integer> ls = new ArrayList<>();
        for (int k = max - 1; k >= 0; k--) {
            ls.add(nums[hashIndex]);
            hashIndex = hash[hashIndex];
        }
        return ls;
    }

    private int f(int[] nums, int prev, int curr) {
        if (curr == nums.length) return 0;

        int take = 0;
        if (prev == -1 || nums[curr] % nums[prev] == 0) {
            take = 1 + f(nums, curr, curr + 1);
        }
        int notTake = f(nums, prev, curr + 1);

        return Math.max(take, notTake);
    }
}