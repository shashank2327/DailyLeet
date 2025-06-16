class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][][] memo = new int[n + 1][n + 1][3];
        for (int[][] mat : memo) {
            for (int[] x : mat) {
                Arrays.fill(x, -1);
            }
        }
        return wiggleLength(nums, 0, -1, 0, memo);
    }

    private int wiggleLength(
        int[] nums,
        int i, 
        int j, 
        int flag,
        int[][][] memo
    ) 
    {
        if (i == nums.length) {
            return 0;
        }
        if (memo[i + 1][j + 1][flag + 1] != -1) {
            return memo[i + 1][j + 1][flag + 1];
        }

        int ans = Integer.MIN_VALUE;
        if (flag == 0) {
            if (j == -1) {
                ans = Math.max(ans, 1 + wiggleLength(nums, i + 1, i, 0, memo));
            } else if (nums[i] != nums[j]) {
                int myFlag = nums[i] - nums[j] > 0 ? 1 : -1;
                ans = Math.max(ans, 1 + wiggleLength(nums, i + 1, i, myFlag, memo));
            }
        } else if (flag == 1 && nums[i] - nums[j] < 0) {
            ans = Math.max(ans, 1 + wiggleLength(nums, i + 1, i, -1, memo));
        } else if (flag == -1 && nums[i] - nums[j] > 0) {
            ans = Math.max(ans, 1 + wiggleLength(nums, i + 1, i, 1, memo));
        }

        ans = Math.max(ans, wiggleLength(nums, i + 1, j, flag, memo));

        return memo[i + 1][j + 1][flag + 1] = ans;
    }
}