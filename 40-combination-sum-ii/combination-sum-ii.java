class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        fun(nums, target, 0, 0, -1, new ArrayList<>(), res);
        return res;
    }
    
    private void fun(
        int[] nums,
        int target,
        int currsum,
        int i,
        int j,
        List<Integer> temp,
        List<List<Integer>> res
    ){

        if (currsum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (currsum > target || i == nums.length) {
            return;
        }


        if (i == 0 || !(i != j + 1 && nums[i] == nums[i - 1])) {
            if (currsum + nums[i] <= target) {
                temp.add(nums[i]);
                fun(nums, target, currsum + nums[i], i + 1, i, temp, res);
                temp.remove(temp.size() - 1);
            } 
            
        }

        fun(nums, target, currsum, i + 1, j, temp, res);
    }
}