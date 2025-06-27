class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        fun(nums, 0, new ArrayList<>(), result);
        return result;
    }
    public void fun(int[] nums, int idx, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));

        for (int i = idx; i < nums.length; i++) {
            temp.add(nums[i]);
            fun(nums, i + 1,  temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}