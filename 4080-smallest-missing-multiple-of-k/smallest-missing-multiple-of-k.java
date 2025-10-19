class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int i = 1;
        int ans = -1;
        while (true) {
            int val = k * i;
            if (!set.contains(val)) {
                ans = val;
                break;
            }
            i++;
        }

        return ans;
    }
}