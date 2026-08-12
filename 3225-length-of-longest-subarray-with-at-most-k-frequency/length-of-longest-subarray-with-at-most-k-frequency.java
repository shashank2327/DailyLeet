class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        int maxi = -1;
        int left = 0;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (left <= i && map.get(nums[i]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            maxi = Math.max(maxi, i - left + 1);
        }

        return maxi;
    }
}