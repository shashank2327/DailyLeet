class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //[1, 2, 3, 4, 5, 6, 7, 8, 9];
        List<List<Integer>> res = new ArrayList<>();
        fun(1, 0, k, 0, n, new ArrayList<>(), res);
        return res;
    }
    public void fun(
        int idx,
        int cnt,
        int k,
        int currSum,
        int target,
        List<Integer> temp,
        List<List<Integer>> res
    ) 
    {   
        if (cnt > k || currSum > target) {
            return;
        }

        if (cnt == k && currSum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i <= 9; i++) {
            temp.add(i);
            fun(i + 1, cnt + 1, k, currSum + i, target, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}