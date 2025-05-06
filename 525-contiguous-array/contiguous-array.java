class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }

        int sum = 0;
        int winSize = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, - 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                winSize = Math.max(winSize, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return winSize;
    }
}