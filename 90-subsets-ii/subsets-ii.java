class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        fun(nums, 0, -1, res, new ArrayList<>());
        return res;
    }

    private void fun(int[] nums, int currIdx, int prevIdx, List<List<Integer>> res, List<Integer> temp) {

        if (currIdx == nums.length) {
            // add the copy of temp in result list;
            res.add(new ArrayList<>(temp));
            return;
        }

        // I will only take if nums[i] != nums[i - 1];
        // because if nums[i] == nums[i - 1];
        // the earlier occurred same element had produced all the combination with remaing elements;

        if (currIdx == 0 || !(currIdx != prevIdx + 1 && nums[currIdx] == nums[currIdx - 1])) {
            temp.add(nums[currIdx]);
            fun(nums, currIdx + 1, currIdx, res, temp);
            temp.remove(temp.size() - 1);
        }


        // not take case;
        fun(nums, currIdx + 1, prevIdx, res, temp);
    }
}