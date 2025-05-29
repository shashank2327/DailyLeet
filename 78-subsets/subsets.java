class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        fun(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void fun(int[] nums, int idx, List<Integer> temp, List<List<Integer>> res) {
        if (idx == nums.length) {
            // add the copy of temp in result list.
            res.add(new ArrayList<>(temp));
            return;
        }

        // pick and call the function for next idx;
        temp.add(nums[idx]);

        fun(nums, idx + 1, temp, res);

        // When the func returns again to this idx.
        // take the case of not picking up;

        // removed the current element since we have earlier picked it up
        temp.remove(temp.size() - 1);

        fun(nums, idx + 1, temp, res);
    }
}