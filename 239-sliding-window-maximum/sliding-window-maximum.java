class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        result[0] = map.firstKey();
        int l = 0;
        int r = k;
        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            map.put(nums[l], map.get(nums[l]) - 1);
            if (map.get(nums[l]) == 0) {
                map.remove(nums[l]);
            }
            l++;
            result[l] = map.firstKey();
            r++;
        }

        return result;
    }
}