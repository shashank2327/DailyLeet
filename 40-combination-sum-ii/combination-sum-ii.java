class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        fun(candidates, 0, 0, target, new ArrayList<>(), result);
        return result;
    }
    public void fun(int[] nums, int idx, int sum, int target, List<Integer> temp, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target || idx == nums.length) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            fun(nums, i + 1, sum + nums[i], target, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}

// -----> 10,1,2,7,6,1,5

// -----> 1,1,2,5,6,7,10