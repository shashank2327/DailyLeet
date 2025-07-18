class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        fun(nums, 0, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void fun(int[] nums, int idx, int currsum, int target,List<Integer> temp, List<List<Integer>> res) {

        if (currsum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (currsum > target || idx == nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            temp.add(nums[i]);
            fun(nums, i, currsum + nums[i], target, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}