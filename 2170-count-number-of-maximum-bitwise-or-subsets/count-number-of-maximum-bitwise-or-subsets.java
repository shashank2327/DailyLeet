class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = max | num;
        }

        return countSubsets(nums, 0, 0, max);
    }

    public int countSubsets(int[] nums, int idx, int currOr, int targetOr) {
        if (idx == nums.length) {
            return (currOr == targetOr) ? 1 : 0;
        }

        // take it
        int take = countSubsets(nums, idx + 1, currOr | nums[idx], targetOr);

        // do not take it
        int notTake = countSubsets(nums, idx + 1, currOr, targetOr);


        return take + notTake;
    }
}