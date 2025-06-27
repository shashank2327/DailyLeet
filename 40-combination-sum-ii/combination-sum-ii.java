class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        fun(candidates, 0, 0, target, new ArrayList<>(), res);
        return res;
    }

    public void fun(int[] nums, int idx, int curr, int target, List<Integer> temp, List<List<Integer>> res) {
        if (curr == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (curr > target || idx == nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            fun(nums, i + 1, curr + nums[i], target, temp, res);

            temp.remove(temp.size() - 1);
        }
    }
}