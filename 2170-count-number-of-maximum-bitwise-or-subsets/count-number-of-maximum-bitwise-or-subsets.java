class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = max | num;
        }

        Integer[][] memo = new Integer[n][max + 1];
        return countSubsets(nums, 0, 0, max, memo);
    }

    public int countSubsets(int[] nums, int idx, int currOr, int targetOr, Integer[][] memo) {
        if (idx == nums.length) {
            return (currOr == targetOr) ? 1 : 0;
        }

        if (memo[idx][currOr] != null) return memo[idx][currOr];

        // take it
        int take = countSubsets(nums, idx + 1, currOr | nums[idx], targetOr, memo);

        // do not take it
        int notTake = countSubsets(nums, idx + 1, currOr, targetOr, memo);


        return memo[idx][currOr] = take + notTake;
    }
}