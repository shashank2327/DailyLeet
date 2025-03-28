class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int sum = 0;
        int l = 0;
        int r = 0;

        while (r < n) {
            if (!map.containsKey(nums[r])) {
                map.put(nums[r], r);
                sum += nums[r];
                r++;
                max = Math.max(max, sum);
            } else {
                int idx = map.get(nums[r]);
                while (l <= idx) {
                    sum -= nums[l];
                    map.remove(nums[l]);
                    l++;
                }
                max = Math.max(sum, max);
            }
        }

        return max;
    }
}