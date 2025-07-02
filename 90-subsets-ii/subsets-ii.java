class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        fun(nums, 0, new ArrayList<>(), result);
        return result;
    }
    public void fun(int[] nums, int idx, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            
            temp.add(nums[i]);
            fun(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}