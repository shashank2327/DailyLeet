class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        fun(1, k, 0, n, new ArrayList<>(), result);
        return result;
    }
    public void fun(
        int idx,
        int k,
        int sum,
        int n,
        List<Integer> temp,
        List<List<Integer>> result
    ) {
        if (k == 0) {
            if (sum == n) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        if (sum > n) return;

        for (int i = idx; i <= 9; i++) {
            temp.add(i);
            fun(i + 1, k - 1, sum + i, n, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}