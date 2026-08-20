class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        l1.add(nums[0]);
        l2.add(nums[1]);

        for (int i = 2; i < n; i++) {
            int val1 = l1.get(l1.size() - 1);
            int val2 = l2.get(l2.size() - 1);

            if (val1 > val2) {
                l1.add(nums[i]);
            } else {
                l2.add(nums[i]);
            }
        }

        for (int i = 0; i < l1.size(); i++) {
            result[i] = l1.get(i);
        }

        for (int i = l1.size(); i < l1.size() + l2.size(); i++) {
            result[i] = l2.get(i - l1.size());
        }

        return result;
    }
}