class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            int val = nums[right];
            sum += val;
            while (map.containsKey(val) && map.get(val) == 1) {
                sum -= nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
            max = Math.max(max, sum);
            right++;
        }

        return max;
    }
}