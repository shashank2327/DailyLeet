class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
        }

        if (k > min) return -1;

        if (k == min) {
            return set.size() - 1;
        } else {
            return set.size();
        }
    }
}