class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        fun(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void fun(int[] nums, int idx, List<List<Integer>> res, List<Integer> temp) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        int size = temp.size();
        for (int i = 0; i <= size; i++) {
            temp.add(i, nums[idx]);
            fun(nums, idx + 1, res, temp);
            temp.remove(i);
        }
    }
}