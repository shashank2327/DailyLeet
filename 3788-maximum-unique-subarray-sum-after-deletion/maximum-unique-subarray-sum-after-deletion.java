class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            if (num < 0) continue;
            if (!set.contains(num)) {
                sum += num;
                set.add(num);
            }
        }
        if (max < 0) return max;
        return sum;
    }
}